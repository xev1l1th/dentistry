package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepo extends JpaRepository<ExpenseType, Long> {
}
