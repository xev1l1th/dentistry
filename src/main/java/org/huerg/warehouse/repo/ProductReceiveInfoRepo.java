package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.productreceipt.ProductReceiveInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReceiveInfoRepo extends JpaRepository<ProductReceiveInfo, Long> {
}
