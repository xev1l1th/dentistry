package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPriceSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleProductPriceSettingsRepo extends JpaRepository<SaleProductPriceSetting, Long> {
}
