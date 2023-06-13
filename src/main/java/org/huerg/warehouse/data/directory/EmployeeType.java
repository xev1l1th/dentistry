package org.huerg.warehouse.data.directory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeType {

    SUPERVISOR("Руководитель"), SUBORDINATE("Подчиненный");

    private final String name;
}
