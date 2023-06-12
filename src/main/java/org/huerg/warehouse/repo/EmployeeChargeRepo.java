package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.employeecharge.EmployeeCharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeChargeRepo extends JpaRepository<EmployeeCharge, Long> {
}
