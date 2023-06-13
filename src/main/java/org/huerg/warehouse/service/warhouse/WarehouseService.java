package org.huerg.warehouse.service.warhouse;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Warehouse;
import org.huerg.warehouse.data.directory.WarehouseType;
import org.huerg.warehouse.repo.WarehouseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepo repo;

    public void createWarehouse(String name, Employee responsible, WarehouseType type){
        repo.save(
                Warehouse
                        .builder()
                        .name(name)
                        .responsibleEmployee(responsible)
                        .documentType(type)
                        .build()
        );
    }

    public List<Warehouse> getAll() {
        return repo.findAll();
    }

    public void update(Warehouse warehouse) {
        repo.save(warehouse);
    }

    public void delete(Warehouse warehouse) {
        repo.delete(warehouse);
    }
}
