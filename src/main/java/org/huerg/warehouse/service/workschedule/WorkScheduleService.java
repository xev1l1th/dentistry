package org.huerg.warehouse.service.workschedule;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.WorkSchedule;
import org.huerg.warehouse.repo.WorkScheduleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkScheduleService {

    private final WorkScheduleRepo workScheduleRepo;

    public void createWorkScheduleType(String name) {
        workScheduleRepo
                .save(
                    WorkSchedule
                            .builder()
                            .name(name)
                .build());
    }

    public void update(WorkSchedule workSchedule) {
        workScheduleRepo.save(workSchedule);
    }

    public List<WorkSchedule> getAll() {
        return workScheduleRepo.findAll();
    }

}
