package hr.stratusit.webshop.service;

import java.math.BigDecimal;

public interface IProduct {

    /**
     *
     * @return Name of the producer
     */
    String getProducer();

    /**
     *
     * @return Name of the product
     */
    String getName();

    /**
     *
     * @return Description of the product
     */
    String getDescription();

    /**
     *
     * @return Single price of the product
     */
    BigDecimal getPrice();

    /**
     *
     * @return Current stock amount of the product in warehouse
     */
    BigDecimal getStockAmount();

}
