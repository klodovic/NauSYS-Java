package hr.stratusit.webshop.utills;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;


public final class Constants {
    static final String relativePath = "cjenik.csv";
    public static final Path DATA_PATH = Paths.get(relativePath).toAbsolutePath();
    public static final String DEL = ",";
    public static final String DATE_DEL = "-";
    public static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder().appendPattern("dd.MM.yyyy").toFormatter(Locale.GERMANY);
}
