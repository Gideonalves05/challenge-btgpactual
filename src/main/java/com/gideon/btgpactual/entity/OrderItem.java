package com.gideon.btgpactual.entity;

import java.math.BigDecimal;

public class OrderItem {

    private String product;

    private Integer quantity;

    private BigDecimal price;

    public OrderItem() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}