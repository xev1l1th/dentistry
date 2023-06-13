package org.huerg.warehouse.service.product;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public void create(String name, String description) {
        productRepo.save(
                Product
                        .builder()
                        .description(description)
                        .name(name)
                        .build()
        );
    }
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public void update(Product product) {
        productRepo.save(product);
    }

    public void delete(Product product) {
        productRepo.delete(product);
    }
}
