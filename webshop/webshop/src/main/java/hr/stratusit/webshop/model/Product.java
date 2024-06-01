package hr.stratusit.webshop.model;

import hr.stratusit.webshop.service.IProduct;
import java.math.BigDecimal;

public class Product implements IProduct {

    private String producer;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal stockAmount;

    public Product(String producer, String name, String description, BigDecimal price, BigDecimal stockAmount) {
        this.producer = producer;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    @Override
    public String getProducer() {
        return producer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public BigDecimal getStockAmount() {
        return stockAmount;
    }


    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "producer='" + producer + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockAmount=" + stockAmount +
                '}';
    }
}
