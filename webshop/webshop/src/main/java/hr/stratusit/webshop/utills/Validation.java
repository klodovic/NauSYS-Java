package hr.stratusit.webshop.utills;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static hr.stratusit.webshop.utills.Constants.YEAR_END;
import static hr.stratusit.webshop.utills.Constants.YEAR_START;

public class Validation {
    public boolean isDateValid(String start, String end) {
        LocalDate rentalStart = dateFormat(start);
        LocalDate rentalEnd = dateFormat(end);
        return (!rentalStart.isBefore(YEAR_START) && !rentalStart.isAfter(YEAR_END)) &&
                (!rentalEnd.isBefore(YEAR_START) && !rentalEnd.isAfter(YEAR_END));
    }

    public boolean isRentalEndsBeforeRentalStart(String start, String end) {
        LocalDate rentalStart = dateFormat(start);
        LocalDate rentalEnd = dateFormat(end);
        return !rentalEnd.isBefore(rentalStart);
    }

    private LocalDate dateFormat(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


}
