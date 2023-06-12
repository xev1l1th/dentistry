package org.huerg.warehouse.service.product;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.data.directory.Warehouse;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceiveInfo;
import org.huerg.warehouse.data.documents.vendorsprice.ContractorProductPrice;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.repo.ProductReceiptRepo;
import org.huerg.warehouse.repo.ProductReceiveInfoRepo;
import org.huerg.warehouse.service.reports.ContractorPriceReportService;
import org.huerg.warehouse.service.warhouse.WarehouseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReceiptService {

    private final ProductReceiptRepo productReceiptRepo;
    private final ContractorPriceReportService contractorPriceReportService;
    private final ProductReceiveInfoRepo infoRepo;

    public List<String> getAllDates() {
        return contractorPriceReportService
                .getAll()
                .stream()
                .map(ContractorProductPrice::getCreatedDate)
                .map(LocalDateTime::toString)
                .toList();
    }

    public List<ProductReceipt> getAll() {
        return productReceiptRepo
                .findAll();
    }

    public ProductReceipt getByDate(LocalDateTime dateTime) {
        return productReceiptRepo
                .findAll()
                .stream()
                .filter(p -> p.getLocalDateTime().isEqual(dateTime))
                .findFirst()
                .orElseThrow();
    }

    public void save(String time, Long count, Contractor contractor, Employee employee, Organisation organisation, Warehouse warehouse, ProductPrice productPrice) {
        ProductReceiveInfo build = ProductReceiveInfo
                .builder()
                .receiptCount(count)
                .receivePrice(productPrice.getPrice())
                .product(productPrice.getProduct())
                .build();
        build.calcSum();
        ProductReceiveInfo save = infoRepo.save(build);
        productReceiptRepo.save(
                ProductReceipt
                        .builder()
                        .contractor(contractor)
                        .warehouse(warehouse)
                        .responsibleEmployee(employee)
                        .organisation(organisation)
                        .localDateTime(LocalDateTime.parse(time))
                        .contractorProductPrice(new HashSet<>(Arrays.asList(save)))
                        .build()
        );
    }

    public void update(ProductPrice productPrice, Long count, ProductReceipt productReceipt) {
        ProductReceiveInfo build = ProductReceiveInfo
                .builder()
                .receiptCount(count)
                .receivePrice(productPrice.getPrice())
                .product(productPrice.getProduct())
                .build();
        build.calcSum();
        ProductReceiveInfo save = infoRepo.save(build);
        productReceipt.addProductReceipt(save);
        productReceiptRepo.save(productReceipt);
    }
}
