package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.vendorsprice.ContractorProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ContractorProductPriceRepo extends JpaRepository<ContractorProductPrice, Long> {


    Optional<ContractorProductPrice> findFirstByProductPricesProduct(Product product);

}
