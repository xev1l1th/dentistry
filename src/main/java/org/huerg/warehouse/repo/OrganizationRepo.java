package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organisation, Long> {
}
