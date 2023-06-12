package org.huerg.warehouse.service.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class GroupByInfo {

    private String productName;
    private String wareHouseName;
    private String organization;

}
