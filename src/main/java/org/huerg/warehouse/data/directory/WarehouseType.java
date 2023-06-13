package org.huerg.warehouse.data.directory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WarehouseType {

    PERSONAL("Собственный"), RENTED("Арендуемый"), OPEN("Открытый");

    private final String name;
}
