package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
