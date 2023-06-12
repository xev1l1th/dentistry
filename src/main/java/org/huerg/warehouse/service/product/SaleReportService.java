package org.huerg.warehouse.service.product;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.*;
import org.huerg.warehouse.data.documents.productsale.ProductSale;
import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.repo.ProductSalePriceInfoRepo;
import org.huerg.warehouse.repo.ProductSaleRepo;
import org.huerg.warehouse.repo.SaleProductPriceRepo;
import org.huerg.warehouse.repo.SaleProductPriceSettingsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleReportService {

    private final ProductSaleRepo productSaleRepo;
    private final ProductSalePriceInfoRepo productSalePriceInfoRepo;

    public List<ProductSale> getAll() {
        return productSaleRepo.findAll();
    }


    public void createSale(ProductSalePriceInfo save, Organisation organisation, LocalDateTime now, Employee employee, Contractor contractor) {
        productSaleRepo.save(
                ProductSale
                        .builder()
                        .organisation(organisation)
                        .localDateTime(now)
                        .responsibleEmployee(employee)
                        .contractor(contractor)
                        .warehouse(Warehouse.builder().build())
                        .build()
        );
    }

    public ProductSalePriceInfo saveSaleInfo(Product product, Double price) {
        return productSalePriceInfoRepo.save(
                ProductSalePriceInfo
                        .builder()
                        .product(product)
                        .price(price)
                        .build()
        );
    }
}
