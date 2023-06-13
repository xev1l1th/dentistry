package org.huerg.warehouse.service.reports;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.huerg.warehouse.repo.ProductSalePriceInfoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PopularityReportService {

    final static Integer POPULAR = 300;

    private final ProductSalePriceInfoRepo repo;

    public List<Map.Entry<String, Long>> createReport() {
        //product -> all info about
        Map<String, Set<ProductSalePriceInfo>> collect = repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(es -> es.getProduct().getName(), Collectors.toSet()));
        var res = new HashMap<String, Long>();
        for (var entry: collect.entrySet()) {
            var total = entry.getValue()
                    .stream()
                    .map(ProductSalePriceInfo::getCount)
                    .mapToLong(Long::longValue)
                    .sum();
            res.put(entry.getKey(), total);
        }
        return res.entrySet()
                .stream()
                .sorted((c, o) -> Math.toIntExact(o.getValue() - c.getValue()))
                .collect(Collectors.toList());
    }

}
