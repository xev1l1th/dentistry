package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.employeecharge.EmployeeChargeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeChargeTypeRepo extends JpaRepository<EmployeeChargeType, Long> {
}
