package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.documents.servicedelivery.ServiceDeliveryPrice;
import org.huerg.warehouse.repo.ServiceDeliveryPriceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceReportService {

    private final ServiceDeliveryPriceRepo serviceDeliveryPriceRepo;

    public Set<Map.Entry<String, List<ServiceDeliveryPrice>>> createReport() {
        return serviceDeliveryPriceRepo
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(s -> s.getProduct().getName(), Collectors.toList()))
                .entrySet();


    }
}
