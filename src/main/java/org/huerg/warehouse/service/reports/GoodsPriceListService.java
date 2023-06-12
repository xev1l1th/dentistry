package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.repo.ProductSaleRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GoodsPriceListService {

    private final ProductSaleRepo productSaleRepo;

    public OrganizationPriceDto getPriceList(LocalDateTime localDateTime) {
        var all = productSaleRepo.findDistinctByLocalDateTimeAfter(localDateTime);

        var result = new OrganizationPriceDto();
        for (var entry: all) {
            var contractorProductPrice = entry.getContractorProductPrice();
            if (contractorProductPrice == null) {
                continue;
            }
            for (var v: contractorProductPrice) {
                var price = v.getPrice();
                var name = v.getProduct().getName();
                result.putGoodsPrice(entry.getOrganisation().getName(), name, price);
            }
        }
        return result;
    }

}
