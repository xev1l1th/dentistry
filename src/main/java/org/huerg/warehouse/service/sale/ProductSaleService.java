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
    private final ProductReceiveInfoRepo productReceiveInfoRepoRepo;


    public void checkAmountOfProduct(SaleProductPrice productPrice, Long count) {
        Product product = productPrice.getProduct();
        long countOfProduct = productReceiveInfoRepoRepo.findAll()
                .stream()
                .filter(r -> r.getProduct().getId().equals(product.getId()))
                .map(ProductReceiveInfo::getReceiptCount)
                .mapToLong(Long::longValue)
                .sum();

        if (countOfProduct < count) {
            throw new NotEnoughProductException();
        }
    }
    public void save(String time, Long count, Contractor contractor, Employee employee, Organisation organisation, Warehouse warehouse, SaleProductPrice productPrice) {

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
       return productSaleRepo.findAll();
    }

    public void delete(ProductSale productReceipt) {
        productSaleRepo.delete(productReceipt);
    }
}
