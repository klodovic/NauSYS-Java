package hr.stratusit.webshop.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class RentalPeriod {
    private LocalDate start;
    private LocalDate end;
    private BigDecimal price;

    public RentalPeriod(LocalDate start, LocalDate end, BigDecimal price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RentalPeriod{" +
                "start=" + start +
                ", end=" + end +
                ", price=" + price +
                '}';
    }
}
