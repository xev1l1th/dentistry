package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.vendorsprice.ContractorProductPrice;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.repo.ContractorProductPriceRepo;
import org.huerg.warehouse.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractorPriceReportService {

    private final ContractorProductPriceRepo repo;

    public List<ContractorProductPrice> createReport(List<Product> product) {
        return product
                .stream()
                .map(p -> repo.findFirstByProductPricesProduct(p).get())
                .toList();
    }

    public void createPrice(ProductPrice product, LocalDateTime localDateTime, Employee employee, Contractor contractor) {
        repo.save(
                ContractorProductPrice
                        .builder()
                        .productPrices(new HashSet<>(Arrays.asList(product)))
                        .createdDate(localDateTime)
                        .contractor(contractor)
                        .responsibleEmployee(employee)
                        .build()
        );
    }

    public List<String> getAllDates() {
        return repo
                        .findAll()
                        .stream()
                        .map(ContractorProductPrice::getCreatedDate)
                        .map(LocalDateTime::toString)
                        .toList();
    }

    public ContractorProductPrice getByDate(LocalDateTime localDateTime) {
        return repo
                .findAll()
                .stream()
                .filter(c -> c.getCreatedDate().isEqual(localDateTime))
                .findFirst()
                .orElseThrow();
    }

    public List<ContractorProductPrice> getAll() {
        return repo.findAll();
    }


    public void update(ContractorProductPrice cpp) {
        repo.save(cpp);
    }
}
