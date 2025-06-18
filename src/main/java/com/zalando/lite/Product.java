package com.zalando.lite;

import java.util.List;

/**
 * Represents a product in the ZalandoLite store.
 *
 * Fields:
 *  - int id
 *  - String name
 *  - String category
 *  - double price
 *  - int stock
 *  - List<String> availableSizes
 *
 * Used in:
 *  - InventoryManager (stock control)
 *  - OrderItem (order composition)
 *  - DiscountManager (discount application)
 *  - Review (customer reviews)
 */


public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private List<String> availableSizes;

    public Product(int id, String name, String category, double price, int stock, List<String> availableSizes) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.availableSizes = availableSizes;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public List<String> getAvailableSizes() { return availableSizes; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }
    public void setAvailableSizes(List<String> availableSizes) { this.availableSizes = availableSizes; }

    @Override
    public String toString() {
        return name + " (id=" + id + ", stock=" + stock + ")";
    }

}
