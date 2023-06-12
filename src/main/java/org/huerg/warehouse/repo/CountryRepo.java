package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
