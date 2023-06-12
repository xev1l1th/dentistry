package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.huerg.warehouse.data.documents.productsale.ProductSale;
import org.huerg.warehouse.repo.ProductReceiptRepo;
import org.huerg.warehouse.repo.ProductSaleRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductRemnantReportService {


    private final ProductReceiptRepo productReceiptRepo;

    private final ProductSaleRepo productSaleRepo;

    /* //for test purposes
    private final Random random = new Random();

    Employee getEmployee(String name){
        return new Employee(random.nextLong(),name, EmployeeType.SUPERVISOR, Gender.MALE, "hug", LocalDateTime.now());
    }

    Organisation getOrg(String name) {
        return new Organisation(random.nextLong(), name, "asd", "asd", LocalDateTime.now());
    }

    Warehouse getWarehouse(long id, String name) {
        return new Warehouse(id, name, WarehouseType.PERSONAL, getEmployee("this"));
    }

    Warehouse warehouse1 = getWarehouse(1L, "1");
    Warehouse warehouse2 = getWarehouse(2L, "2");

    Product product1 = new Product(1L, "1", "1");
    Product product2 = new Product(2L, "2", "1");
    Product product3 = new Product(3L, "3", "1");
    Product product4 = new Product(4L, "4", "1");


    ProductReceipt getProductReceipt(String org, Warehouse warehouse, Set<ProductReceiveInfo> product) {
        return new ProductReceipt(random.nextLong(), LocalDateTime.now(), getEmployee("asd"), getContractor("contr"), getOrg(org), warehouse, product);
    }

    ProductSale getProductSale(String org, Warehouse warehouse, Set<ProductSalePriceInfo> product) {
        return new ProductSale(random.nextLong(), LocalDateTime.now(), getEmployee("asd"), getContractor("contr"), getOrg(org), warehouse, product);
    }
    ProductReceiveInfo getProductReceiveInfo(Product product, int count) {
        return new ProductReceiveInfo(random.nextLong(), product, 100D, (long) count, 300D);
    }

    ProductSalePriceInfo getProductSaleInfo(Product product, int count) {
        return new ProductSalePriceInfo(random.nextLong(), product, 100D, (long) count, 300D);
    }
    Contractor getContractor(String name) {
        return new Contractor(random.nextLong(), name, ContractorType.LOX, LocalDateTime.now());
    }

    List<ProductReceipt> getProductReceipt() {
        return List.of(
                getProductReceipt("asd", warehouse1,
                        Set.of(
                                getProductReceiveInfo(product1, 100),
                                getProductReceiveInfo(product2, 200),
                                getProductReceiveInfo(product3, 300))),
                getProductReceipt("asd", warehouse2,
                        Set.of(
                                getProductReceiveInfo(product1, 10),
                                getProductReceiveInfo(product2, 20),
                                getProductReceiveInfo(product4, 40)
                        )),
                getProductReceipt("asd", warehouse1,
                        Set.of(
                                getProductReceiveInfo(product4, 400),
                                getProductReceiveInfo(product2, 100)
                        )
        ));
    }

    List<ProductSale> getProductSale() {
        return List.of(
                getProductSale("asd", warehouse1,
                        Set.of(
                                getProductSaleInfo(product2, 20),
                                getProductSaleInfo(product4, 30)
                        )),
                getProductSale("asd", warehouse2,
                        Set.of(
                                getProductSaleInfo(product2, 8),
                                getProductSaleInfo(product1, 8)
                        )),
                getProductSale("asd", warehouse1,
                        Set.of(
                                getProductSaleInfo(product2, 79),
                                getProductSaleInfo(product3,99))),
                getProductSale("asd", warehouse2,
                        Set.of(
                                getProductSaleInfo(product4, 13),
                                getProductSaleInfo(product2,1)
                        ))

        );
    }

    public static void main(String[] args) {
        ProductRemnantReportService service = new ProductRemnantReportService(null, null);
        var warehouseRemnantInfos = service.calculateProductRemnantReport(null);
        for (var entry: warehouseRemnantInfos.entrySet()) {
            System.out.println(entry);
        }
    }
     */



    public Map<String, Set<WarehouseRemnantInfo>> calculateProductRemnantReport(LocalDateTime localDateTime)  {
        List<ProductReceipt> allReceipt = productReceiptRepo.findAll();
        List<ProductSale> allSale = productSaleRepo.findAll();

        Map<GroupByInfo, WarehouseRemnantInfo> receiptReportInfo = new HashMap<>();
        Map<GroupByInfo, WarehouseRemnantInfo> saleReportInfo = new HashMap<>();

        //for receipt
        for (var receipt: allReceipt) {
            String warehouseName = receipt.getWarehouse().getName();
            String organizationName = receipt.getOrganisation().getName();
            var contractorProductPrice = receipt.getContractorProductPrice();
            for (var cpp: contractorProductPrice) {
                String productName = cpp.getProduct().getName();
                var key = new GroupByInfo(productName, warehouseName, organizationName);
                WarehouseRemnantInfo value = receiptReportInfo.get(key);
                if (value == null) {
                    //to make it mutable
                    Map<String, Integer> info = new HashMap<>();
                    info.put(productName, Math.toIntExact(cpp.getReceiptCount()));
                    var newValue = new WarehouseRemnantInfo(warehouseName, info);
                    receiptReportInfo.put(key, newValue);
                } else {
                    value.putProduct(productName, Math.toIntExact(cpp.getReceiptCount()));
                }
            }
        }

        //for sale
        for (var sale: allSale) {
            String warehouseName = sale.getWarehouse().getName();
            String organizationName = sale.getOrganisation().getName();
            var contractorProductPrice = sale.getContractorProductPrice();
            for (var cpp: contractorProductPrice) {
                String productName = cpp.getProduct().getName();
                var key = new GroupByInfo(productName, warehouseName, organizationName);
                WarehouseRemnantInfo value = saleReportInfo.get(key);
                if (value == null) {
                    //to make it mutable
                    Map<String, Integer> info = new HashMap<>();
                    info.put(productName, Math.toIntExact(cpp.getCount()));
                    var newValue = new WarehouseRemnantInfo(warehouseName, info);
                    saleReportInfo.put(key, newValue);
                } else {
                    value.putProduct(productName, Math.toIntExact(cpp.getCount()));
                }
            }
        }


        Map<String, Set<WarehouseRemnantInfo>> total = new HashMap<>();

        for (var entry: receiptReportInfo.entrySet()) {
            GroupByInfo key = entry.getKey();
            WarehouseRemnantInfo receipt = entry.getValue();
            WarehouseRemnantInfo sale = saleReportInfo.get(key);
            Map<String, Integer> receiptProductInfo = receipt.getProductInfo();
            for (var receiptEntry: receiptProductInfo.entrySet()) {
                var v = total.get(key.getOrganization());
                Integer integer;
                if (sale == null) {
                    integer = 0;
                } else {
                    integer = sale.getProductInfo().getOrDefault(receiptEntry.getKey(), 0);
                }
                var mapValue = receiptEntry.getValue() - integer;
                if (v == null) {
                    Map<String, Integer> map = new HashMap<>();
                    map.put(receiptEntry.getKey(), mapValue);
                    var value = new WarehouseRemnantInfo(key.getWareHouseName(), map);
                    total.put(key.getOrganization(), new HashSet<>(Arrays.asList(value)));
                } else {
                    WarehouseRemnantInfo varehouse = null;
                    for (var e: v) {
                        if (key.getWareHouseName().equals(e.getWarehouse())){
                            varehouse = e;
                        }
                    }
                    if (varehouse != null) {
                        varehouse.putProduct(receiptEntry.getKey(), mapValue);
                        //total.put(key.getOrganization(), v);
                    } else {
                        Map<String, Integer> map = new HashMap<>();
                        map.put(receiptEntry.getKey(), mapValue);
                        v.add(new WarehouseRemnantInfo(key.getWareHouseName(), map));
                    }
                }
            }
        }

        return total;

    }
}

