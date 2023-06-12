package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPriceSetting;
import org.huerg.warehouse.repo.SaleProductPriceRepo;
import org.huerg.warehouse.repo.SaleProductPriceSettingsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleProductPriceSettingsService {

    private final SaleProductPriceSettingsRepo saleProductPriceSettingsRepo;
    private final SaleProductPriceRepo saleProductPriceRepo;
    public List<SaleProductPriceSetting> getAll() {
        return saleProductPriceSettingsRepo.findAll();
    }

    public SaleProductPrice saveSale(Product product, Double price) {
        return saleProductPriceRepo.save(
                SaleProductPrice
                        .builder()
                        .product(product)
                        .price(price)
                        .build()
        );
    }

    public void createSaleIngo(SaleProductPrice save, LocalDateTime now, Employee employee, Contractor contractor) {
        saleProductPriceSettingsRepo.save(
                SaleProductPriceSetting
                        .builder()
                        .createdDate(now)
                        .contractor(contractor)
                        .responsibleEmployee(employee)
                        .productPrices(new HashSet<>(Arrays.asList(save)))
                        .build()
        );
    }

    public void update(SaleProductPrice saleProductPrice) {
        saleProductPriceRepo.save(saleProductPrice);
    }

    public void updateSale(SaleProductPriceSetting spp) {
        saleProductPriceSettingsRepo.save(spp);
    }

    public List<String> getAllDates() {
        return saleProductPriceSettingsRepo
                .findAll()
                .stream()
                .map(c -> c.getCreatedDate())
                .map(c -> c.toString())
                .toList();
    }

    public SaleProductPriceSetting getByDate(LocalDateTime parse) {
        return saleProductPriceSettingsRepo
                .findAll()
                .stream()
                .filter(c -> c.getCreatedDate().isEqual(parse))
                .findFirst()
                .orElseThrow();
    }
}
