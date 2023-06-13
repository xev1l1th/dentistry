package org.huerg.warehouse.data.directory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeType {

    SUPERVISOR("БОС"), SUBORDINATE("СОТРУДНИК");

    private final String name;
}
