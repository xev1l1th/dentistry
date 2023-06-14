package org.huerg.warehouse.service.sale;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.*;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceiveInfo;
import org.huerg.warehouse.data.documents.productsale.ProductSale;
import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.exception.NotEnoughProductException;
import org.huerg.warehouse.repo.ProductReceiptRepo;
import org.huerg.warehouse.repo.ProductReceiveInfoRepo;
import org.huerg.warehouse.repo.ProductSalePriceInfoRepo;
import org.huerg.warehouse.repo.ProductSaleRepo;
import org.huerg.warehouse.service.reports.ProductRemnantReportService;
import org.huerg.warehouse.service.reports.WarehouseRemnantInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductSaleService {

    private final ProductSaleRepo productSaleRepo;
    private final ProductSalePriceInfoRepo productSalePriceInfoRepo;
    private final ProductReceiveInfoRepo productReceiveInfoRepoRepo;
    private final ProductRemnantReportService remnantReportService;


    private void checkAmountOfProduct(SaleProductPrice productPrice, Long count) {
        Map<String, Set<WarehouseRemnantInfo>> stringSetMap = remnantReportService.calculateProductRemnantReport(null);
        //find all our products
        var countOfProduct = 0;
        for(var entry: stringSetMap.entrySet()) {
            for (var s : entry.getValue()) {
                var c = Optional.ofNullable(s.getProductInfo())
                        .map(i -> i.get(productPrice.getProduct().getName()))
                        .orElse(0);
                countOfProduct += c;
            }
        }

         if (countOfProduct < count) {
            throw new NotEnoughProductException();
        }
    }
    public void save(String time, Long count, Contractor contractor, Employee employee, Organisation organisation, Warehouse warehouse, SaleProductPrice productPrice, boolean fromOrder) {

        checkAmountOfProduct(productPrice, count);

        ProductSalePriceInfo build = ProductSalePriceInfo
                .builder()
                .count(count)
                .price(productPrice.getPrice())
                .product(productPrice.getProduct())
                .build();
        build.calcSum();
        ProductSalePriceInfo save = productSalePriceInfoRepo.save(build);
        productSaleRepo.save(
                ProductSale
                        .builder()
                        .contractor(contractor)
                        .warehouse(warehouse)
                        .responsibleEmployee(employee)
                        .organisation(organisation)
                        .localDateTime(LocalDateTime.parse(time))
                        .contractorProductPrice(new HashSet<>(Arrays.asList(save)))
                        .fromOrder(fromOrder)
                        .build()
        );
    }

    public void update(ProductSale productSale, Long count, SaleProductPrice spp) {
        checkAmountOfProduct(spp, count);
        ProductSalePriceInfo build = ProductSalePriceInfo
                .builder()
                .count(count)
                .price(spp.getPrice())
                .product(spp.getProduct())
                .build();
        build.calcSum();
        ProductSalePriceInfo save = productSalePriceInfoRepo.save(build);
        productSale.getContractorProductPrice().add(save);
        productSaleRepo.save(productSale);
    }

    public List<ProductSale> getAll() {
       return productSaleRepo.findAll()
               .stream()
               .filter(p -> !p.isFromOrder())
               .toList();
    }

    public void delete(ProductSale productReceipt) {
        productSaleRepo.delete(productReceipt);
    }
}
