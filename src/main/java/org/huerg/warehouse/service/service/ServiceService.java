package org.huerg.warehouse.service.service;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.data.directory.ServiceType;
import org.huerg.warehouse.data.documents.servicedelivery.ServiceDelivery;
import org.huerg.warehouse.data.documents.servicedelivery.ServiceDeliveryPrice;
import org.huerg.warehouse.repo.ServiceDeliveryPriceRepo;
import org.huerg.warehouse.repo.ServiceDeliveryRepo;
import org.huerg.warehouse.repo.ServiceRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepo serviceRepo;
    private final ServiceDeliveryRepo serviceDeliveryRepo;
    private final ServiceDeliveryPriceRepo serviceDeliveryPriceRepo;

    public void createService(String name, String description, ServiceType type) {
        serviceRepo.save(
                org.huerg.warehouse.data.directory.Service
                        .builder()
                        .serviceType(type)
                        .description(description)
                        .name(name)
                        .build()
        );
    }

    public ServiceDeliveryPrice saveServiceDeliveryPrice(org.huerg.warehouse.data.directory.Service service, Double price) {
        return serviceDeliveryPriceRepo.save(
                ServiceDeliveryPrice
                        .builder()
                        .price(price)
                        .product(service)
                        .build()
        );
    }

    public Set<ServiceDeliveryPrice> createReport(String organizationName) {
        return serviceDeliveryRepo.findDistinctByOrganisationName(organizationName)
                .stream()
                .map(ServiceDelivery::getServiceDeliveryPrices)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

    }

    public List<org.huerg.warehouse.data.directory.Service> getAll() {
        return serviceRepo.findAll();
    }

    public List<ServiceDelivery> getAllServiceDelivery() {
        return serviceDeliveryRepo.findAll();
    }

    public void update(org.huerg.warehouse.data.directory.Service service) {
        serviceRepo.save(service);
    }

    public void createServiceDelivery(Contractor contractor, Organisation organisation, Employee employee, ServiceDeliveryPrice serviceDeliveryPrice) {
        serviceDeliveryRepo.save(
                ServiceDelivery
                        .builder()
                        .serviceDeliveryPrices(new HashSet<>(Arrays.asList(serviceDeliveryPrice)))
                        .contractor(contractor)
                        .organisation(organisation)
                        .responsibleEmployee(employee)
                        .build()
        );
    }

    public void update(ServiceDelivery serviceDelivery) {
        serviceDeliveryRepo.save(serviceDelivery);
    }

    public void update(ServiceDeliveryPrice serviceDeliveryPrice) {
        serviceDeliveryPriceRepo.save(serviceDeliveryPrice);
    }
}
