package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.directory.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepo extends JpaRepository<WorkSchedule, Long> {
}
