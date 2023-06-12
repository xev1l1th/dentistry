package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepo extends JpaRepository<Contract, Long> {
}
