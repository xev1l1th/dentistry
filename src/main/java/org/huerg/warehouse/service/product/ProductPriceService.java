package org.huerg.warehouse.service.product;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.repo.ProductPriceRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepo productPriceRepo;

    public ProductPrice save(Product product, Double price) {
        return productPriceRepo.save(
                ProductPrice
                        .builder()
                        .price(price)
                        .product(product)
                        .build()
        );
    }

    public void update(ProductPrice productPrice) {
        productPriceRepo.save(productPrice);
    }
}
