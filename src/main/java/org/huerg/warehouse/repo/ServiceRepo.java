package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepo extends JpaRepository<Service, Long> {

}
