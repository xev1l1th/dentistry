package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReceiptRepo extends JpaRepository<ProductReceipt, Long> {
}
