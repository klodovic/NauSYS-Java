package hr.stratusit.webshop.utills;

import hr.stratusit.webshop.model.Boat;
import hr.stratusit.webshop.service.RentalPeriod;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static hr.stratusit.webshop.utills.Constants.*;
import static hr.stratusit.webshop.utills.Constants.DATE_FORMATTER;

public class LoadData {
    List<Boat> boats = new ArrayList<>();
    List<String> lines = new ArrayList<>();
    List<String> periods = new ArrayList<>();


    public List<Boat> readCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(DATA_PATH)));
            String line = "";
            while ((line = br.readLine()) != null){
                //System.out.println(line);
                if (line.isEmpty()){
                    break;
                }
                lines.add(line);
            }

            //First Line
            String[] header = lines.get(0).split(DEL);
            for (int i = 0; i < header.length; i++) {
                if (!header[i].isEmpty()){
                    periods.add(header[i]);
                }
            }

            //Boats Lines
            for (int i = 1; i < lines.size() ; i++) {
                String[] boatData = lines.get(i).split(DEL);

                int id = Integer.parseInt(boatData[0]);
                String name = boatData[1];
                int year = Integer.parseInt(boatData[2]);
                //System.out.println(id + name + year);

                //Creating the List of rental periods for each boat

                List<RentalPeriod> rentalPeriods = new ArrayList<>();
                int index = 3;
                for (int j = 0; j < periods.size() ; j++) {
                    String[] dates = periods.get(j).split(DATE_DEL);
                    LocalDate start = LocalDate.parse(dates[0], DATE_FORMATTER);
                    LocalDate end = LocalDate.parse(dates[1], DATE_FORMATTER);
                    BigDecimal price = new BigDecimal(boatData[index]);
                    index += 1;
                    rentalPeriods.add(new RentalPeriod(start, end, price));
                }
                boats.add(new Boat(id, name, year, rentalPeriods));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return boats;
    }
}
