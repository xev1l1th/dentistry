package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.servicedelivery.ServiceDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceDeliveryRepo extends JpaRepository<ServiceDelivery, Long> {

    List<ServiceDelivery> findDistinctByOrganisationName(String name);

}
