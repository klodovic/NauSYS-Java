package hr.stratusit.webshop.utills;

import hr.stratusit.webshop.model.Boat;
import hr.stratusit.webshop.model.RentalPeriod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Calculator {
    public BigDecimal calculatePrice(List<Boat> boats, int id, String start, int rentalDuration) {

        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        BigDecimal price = BigDecimal.ZERO;

        for (int i = 0; i < boats.size(); i++) {
            int boatId = boats.get(i).getId();
            if (id == boatId){
                List<RentalPeriod> rp = boats.get(i).getRentalPeriods();
                for (int j = 0; j < rp.size(); j++) {

                    if ((rp.get(0).getStart()).isEqual(startDate) || (rp.get(0).getStart()).isAfter(startDate)) {
                        price = sumCalculating(rp.get(0).getPrice(), rentalDuration);
                        break;
                    }
                    else if ((rp.get(1).getStart()).isEqual(startDate) || (rp.get(1).getStart()).isAfter(startDate)) {
                        price = sumCalculating(rp.get(1).getPrice(), rentalDuration);
                        break;
                    }
                    else if ((rp.get(2).getStart()).isEqual(startDate) || (rp.get(2).getStart()).isAfter(startDate)) {
                        price = sumCalculating(rp.get(2).getPrice(), rentalDuration);
                        break;
                    }
                    else if ((rp.get(3).getStart()).isEqual(startDate) || (rp.get(3).getStart()).isAfter(startDate)) {
                        price = sumCalculating(rp.get(3).getPrice(), rentalDuration);
                        break;
                    }
                }
                break;
            }
        }
        return price;
    }


    private BigDecimal sumCalculating(BigDecimal boatPrice, int rentalDuration) {
        BigDecimal price = BigDecimal.ZERO;
        price = price.add(boatPrice);
        price = price.multiply(BigDecimal.valueOf(rentalDuration));
        return price;
    }

}
