package hr.stratusit.webshop.service;

import hr.stratusit.webshop.service.IProduct;
import hr.stratusit.webshop.service.IShoppingItem;
import java.math.BigDecimal;
import java.util.Date;

public class ShoppingItem implements IShoppingItem {
    private Long id;
    private IProduct product;
    private BigDecimal quantity;
    private Date lastModifyTime;

    public ShoppingItem(Long id, IProduct product, BigDecimal quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.lastModifyTime = new Date();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public IProduct getProduct() {
        return product;
    }

    @Override
    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getPrice() {
        return product.getPrice();
    }

    @Override
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    @Override
    public BigDecimal getTotalAmount() {
        return product.getPrice().multiply(quantity);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(IProduct product) {
        this.product = product;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", lastModifyTime=" + lastModifyTime +
                '}';
    }
}
