package org.huerg.warehouse.service.income;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.IncomeType;
import org.huerg.warehouse.repo.IncomeTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeTypeRepo repo;

    public void create(String name) {
        repo.save(IncomeType
                .builder()
                        .name(name)
                .build());
    }

    public void update(IncomeType incomeType) {
        repo.save(incomeType);
    }

    public List<IncomeType> getAll() {
        return repo.findAll();
    }

    public void delete(IncomeType incomeType) {
        repo.delete(incomeType);
    }
}
