package org.huerg.warehouse.service.sale;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.data.directory.Warehouse;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceiveInfo;
import org.huerg.warehouse.data.documents.productsale.ProductSale;
import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.repo.ProductSalePriceInfoRepo;
import org.huerg.warehouse.repo.ProductSaleRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSaleService {

    private final ProductSaleRepo productSaleRepo;
    private final ProductSalePriceInfoRepo productSalePriceInfoRepo;
    public void save(String time, Long count, Contractor contractor, Employee employee, Organisation organisation, Warehouse warehouse, SaleProductPrice productPrice) {
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
                        .build()
        );
    }

    public void update(ProductSale productSale, Long count, SaleProductPrice spp) {
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
       return productSaleRepo.findAll();
    }
}
