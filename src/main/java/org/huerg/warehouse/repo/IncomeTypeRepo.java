package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.IncomeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeTypeRepo extends JpaRepository<IncomeType, Long> {
}
