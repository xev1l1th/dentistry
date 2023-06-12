package org.huerg.warehouse.service.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
public class OrganizationPriceDto {

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class GoodPriceDto {
        private String name;
        private double price;
    }

    private Map<String, Set<GoodPriceDto>> map = new HashMap<>();

    public void putGoodsPrice(String organizationName, String name, double price) {
        Set<GoodPriceDto> goodPriceDtos = map.get(organizationName);
        if (goodPriceDtos == null) {
            map.put(organizationName, new HashSet<>(Arrays.asList(new GoodPriceDto(name, price))));
        } else {
            goodPriceDtos.add(new GoodPriceDto(name, price));
        }
    }

    public Set<Map.Entry<String, Set<GoodPriceDto>>> getMapAsEntrySet() {
        return getMap().entrySet();
    }


}
