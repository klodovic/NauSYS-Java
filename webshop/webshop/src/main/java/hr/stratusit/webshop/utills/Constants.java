package hr.stratusit.webshop.utills;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;


public final class Constants {
    static final String relativePath = "cjenik.csv";
    public static final Path DATA_PATH = Paths.get(relativePath).toAbsolutePath();
    public static final String DEL = ",";
    public static final String DATE_DEL = "-";
    public static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder().appendPattern("dd.MM.yyyy").toFormatter(Locale.ENGLISH);
    public static final LocalDate YEAR_START = LocalDate.parse("2021-01-01");
    public static final LocalDate YEAR_END = LocalDate.parse("2021-12-31");
    public static final Long MILLISECONDS = 86400000L; //milliseconds in one day
}
