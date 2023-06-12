package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.servicedelivery.ServiceDeliveryPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDeliveryPriceRepo extends JpaRepository<ServiceDeliveryPrice, Long> {
}
