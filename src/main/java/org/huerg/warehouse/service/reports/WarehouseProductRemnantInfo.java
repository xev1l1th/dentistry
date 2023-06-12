package org.huerg.warehouse.service.reports;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseProductRemnantInfo {

    private String productName;
    private int count;
}
