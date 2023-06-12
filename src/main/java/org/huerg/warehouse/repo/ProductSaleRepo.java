package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.productsale.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductSaleRepo extends JpaRepository<ProductSale, Long> {

    List<ProductSale> findDistinctByLocalDateTimeAfter(LocalDateTime localDateTime);
}
