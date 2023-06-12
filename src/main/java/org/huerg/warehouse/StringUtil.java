package org.huerg.warehouse;

import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Consumer;

@UtilityClass
public class StringUtil {

    public boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    public void exec(String param, Consumer<String> consumer) {
        Optional.ofNullable(param).filter(StringUtil::isNotEmpty).ifPresent(consumer);
    }


}
