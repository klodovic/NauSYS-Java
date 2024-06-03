package hr.stratusit.webshop.service;

import hr.stratusit.webshop.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ShoppingCart implements IShoppingCart {

    private Long id;
    private String user;
    private Date createdTime;
    private List<IShoppingItem> items;

    public ShoppingCart(Long id, String user) {
        this.id = id;
        this.user = user;
        this.createdTime = new Date();
        this.items = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setItems(List<IShoppingItem> items) {
        this.items = items;
    }



    //List returns all items sorted alphabetically by Producer and Product name
    @Override
    public List<IShoppingItem> getItems() {
        items.sort(Comparator.comparing(i -> i.getProduct().getProducer() + i.getProduct().getName()));
        return items;
    }


    //Total price of the shopping cart
    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal price = BigDecimal.ZERO;
        for (IShoppingItem item : items){
            price = price.add(item.getPrice());
        }
        return price;
    }

    //This function must assure that every product in shopping cart don't have
    //duplicate items. One product, one ShoppingCartItem.
    @Override
    public boolean addItem(IProduct product, BigDecimal quantity) {
        for (IShoppingItem item : items){
            if (item.getProduct().equals(product)){
                item.setQuantity(item.getQuantity().add(quantity));
                return true;
            }
        }
        items.add(new ShoppingItem(id, product, quantity));
        return true;
    }


    // This function must assure that quantity of the shopping cart item can't
    // be less than zero. If the shopping cart quantity is zero, shopping cart item
    // must be removed from the items list.
    @Override
    public boolean removeItem(IProduct product, BigDecimal quantity) {
        for (IShoppingItem item : items){
            if (item.getProduct().equals(product)){
                if (item.getQuantity().compareTo(quantity) <= 0){
                    items.remove(item);
                }
                else {
                    item.setQuantity(item.getQuantity().subtract(quantity));
                }
                return true;
            }
        }
        return true;
    }

    // Updates the shopping cart items with actual price and quantity. If the
    // quantity of shopping card item is greater the stock amount of the product,
    // quantity must be updated with the current stock amount.
    @Override
    public void refresh() {
        for (IShoppingItem item : items){
            BigDecimal stockAmount = item.getProduct().getStockAmount();
            if (item.getQuantity().compareTo(stockAmount) > 0){
                item.setQuantity(stockAmount);
            }
        }
    }


    // Updates the stock amount of the products, and invalidates current shopping
    // cart
    @Override
    public boolean checkOut() {
        for (IShoppingItem item : items){
            Product product = (Product) item.getProduct();
            BigDecimal stockAmount = item.getProduct().getStockAmount().subtract(item.getQuantity());
            product.setStockAmount(stockAmount);
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", createdTime=" + createdTime +
                ", items=" + items +
                '}';
    }
}
