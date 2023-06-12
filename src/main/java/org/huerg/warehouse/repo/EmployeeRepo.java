package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
