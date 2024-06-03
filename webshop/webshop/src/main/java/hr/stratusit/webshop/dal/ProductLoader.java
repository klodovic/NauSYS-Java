package hr.stratusit.webshop.dal;

import hr.stratusit.webshop.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    private final List<Product> products;
    private void loadProduct(){
        products.add(new Product(
                "Honda",
                "Yacht",
                "Lorem Ipsum is simply dummy text",
                new BigDecimal(100),
                new BigDecimal(100))
        );
        products.add(new Product(
                "Honda2",
                "Boat",
                "Lorem Ipsum",
                new BigDecimal(170),
                new BigDecimal(200)));

        products.add(new Product(
                "Yamaha",
                "Boat",
                "Lorem Ipsum - Lorem Ipsum",
                new BigDecimal(55),
                new BigDecimal(300)));
    }

    public ProductLoader(){
        products = new ArrayList<>();
        loadProduct();
    }
    public List<Product> getProducts() {
        return products;
    }
}
