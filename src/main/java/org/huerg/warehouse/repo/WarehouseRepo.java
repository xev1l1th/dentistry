package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {
}
