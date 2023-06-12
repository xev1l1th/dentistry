package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSalePriceInfoRepo extends JpaRepository<ProductSalePriceInfo, Long> {
}
