package hr.stratusit.webshop.utills;

import hr.stratusit.webshop.model.Boat;
import hr.stratusit.webshop.service.RentalPeriod;
import static hr.stratusit.webshop.utills.Constants.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Calculator {
    public String calculatePrice(List<Boat> boats, int id, String start, String end) throws ParseException {

        LocalDate rentalEnd = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String message = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        Date endOfRental = sdf.parse(end);
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < boats.size(); i++) {
            int boatId = boats.get(i).getId();
            if (id == boatId){
                List<RentalPeriod> rp = boats.get(i).getRentalPeriods();
                for (int j = 0; j < rp.size(); j++) {
                    //check if ending rental day is after ending period (Calculate number of days and price)
                    if (rentalEnd.isAfter(rp.get(j).getEnd())){
                        Date endOfPeriod = Date.from(rp.get(j).getEnd().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Date startOfPeriod = Date.from(rp.get(j).getStart().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        BigDecimal price = rp.get(j).getPrice();
                        sum = sum.add(priceCalculation(endOfPeriod, startOfPeriod, price));
                    }
                    //Calculation within the period
                    else{
                        Date startOfPeriod = Date.from(rp.get(j).getStart().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        BigDecimal price = rp.get(j).getPrice();
                        sum = sum.add(priceCalculation(endOfRental, startOfPeriod, price));
                        break;
                    }
                }
                message = "Total price: " + sum;
            }
        }
        return message;
    }

    private static BigDecimal priceCalculation(Date end, Date start, BigDecimal price) {
        BigDecimal sum = BigDecimal.ZERO;
        long differenceInMilliseconds = Math.abs(end.getTime() - start.getTime());
        BigDecimal days = new BigDecimal(differenceInMilliseconds / MILLISECONDS);
        BigDecimal sumTemp = days.multiply(price);
        sum = sum.add(sumTemp);
        return sum;
    }

}
