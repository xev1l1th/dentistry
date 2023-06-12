package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepo extends JpaRepository<ServiceType, Long> {
}
