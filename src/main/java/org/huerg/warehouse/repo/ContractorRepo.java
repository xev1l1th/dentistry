package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepo extends JpaRepository<Contractor, Long> {
}
