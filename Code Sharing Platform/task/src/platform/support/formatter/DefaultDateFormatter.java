package platform.support.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultDateFormatter {
    private static final String DATE_FORMAT_STRING = "yyyy/dd/MM HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_FORMATTER);
    }
}
