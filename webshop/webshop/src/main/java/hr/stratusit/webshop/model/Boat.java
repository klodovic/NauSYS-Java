package hr.stratusit.webshop.model;

import hr.stratusit.webshop.service.RentalPeriod;

import java.util.List;

public class Boat {
    private int id;
    private String boatName;
    private int productionYear;
    private List<RentalPeriod> rentalPeriods;


    public Boat(int id, String boatName, int productionYear, List<RentalPeriod> rentalPeriods) {
        this.id = id;
        this.boatName = boatName;
        this.productionYear = productionYear;
        this.rentalPeriods = rentalPeriods;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public List<RentalPeriod> getRentalPeriods() {
        return rentalPeriods;
    }

    public void setRentalPeriods(List<RentalPeriod> rentalPeriods) {
        this.rentalPeriods = rentalPeriods;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", name='" + boatName + '\'' +
                ", year=" + productionYear +
                ", periods=" + rentalPeriods+
                '}';
    }
}