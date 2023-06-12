package org.huerg.warehouse.data.directory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WarehouseType {

    PERSONAL("персонал"), RENTED("рентед"), SUPER_SMALL("микросмол");

    private final String name;
}
