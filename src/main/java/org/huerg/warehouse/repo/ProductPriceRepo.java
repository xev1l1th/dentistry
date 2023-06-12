package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepo extends JpaRepository<ProductPrice, Long> {
}
