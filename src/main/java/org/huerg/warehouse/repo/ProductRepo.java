package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
