package com.zalando.lite;

/**
 * Represents an item inside an order.
 *
 * Fields:
 *  - Product product
 *  - int quantity
 *
 * Used by:
 *  - Order
 */


public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + product;
    }

}
