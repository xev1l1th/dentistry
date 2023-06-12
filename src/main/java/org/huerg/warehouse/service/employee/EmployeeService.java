package org.huerg.warehouse.service.employee;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.EmployeeType;
import org.huerg.warehouse.data.directory.Gender;
import org.huerg.warehouse.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo repo;

    public void createEmployee(String name, Gender gender, EmployeeType type, String position) {
        repo.save(
                Employee
                        .builder()
                        .name(name)
                        //todo .birthDate(birthDate)
                        .gender(gender)
                        .employeeType(type)
                        .position(position)
                        .build()
        );
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public void update(Employee employee) {
        repo.save(employee);
    }
}
