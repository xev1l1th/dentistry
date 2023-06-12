package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.documents.employeecharge.EmployeeCharge;
import org.huerg.warehouse.repo.EmployeeChargeRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeChargeReportService {

    private final EmployeeChargeRepo repo;

    public Map<String, Set<EmployeeCharge>> createReport() {

        List<EmployeeCharge> all = repo.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return Collections.emptyMap();
        }

        return all
                .stream()
                .collect(Collectors.groupingBy(ec -> ec.getResponsibleEmployee().getName(), Collectors.toSet()));

    }

}
