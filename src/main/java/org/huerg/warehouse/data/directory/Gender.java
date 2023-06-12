package org.huerg.warehouse.data.directory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {

    MALE("мужской"), FEMALE("женский"), OPTIMUS_PRIME("оптимус_прайм");

    private final String name;
}
