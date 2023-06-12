package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleProductPriceRepo extends JpaRepository<SaleProductPrice, Long> {
}
