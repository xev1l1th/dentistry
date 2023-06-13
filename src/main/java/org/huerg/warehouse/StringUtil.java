package org.huerg.warehouse;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;

@UtilityClass
public class StringUtil {

    private final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    public void exec(String param, Consumer<String> consumer) {
        Optional.ofNullable(param).filter(StringUtil::isNotEmpty).ifPresent(consumer);
    }

    public LocalDateTime convertToDate(String date) {
        try {
            Date parse = SIMPLE_DATE_FORMAT.parse(date);
            return LocalDateTime.ofInstant(parse.toInstant(), ZoneId.systemDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LocalDateTime.now();
    }


}
