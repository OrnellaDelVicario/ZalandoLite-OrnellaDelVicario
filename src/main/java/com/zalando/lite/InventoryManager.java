package com.zalando.lite;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the inventory of products.
 *
 * Responsibilities:
 *  - Add, list, and find products by ID.
 *
 * Methods:
 *  - addProduct(Product product)
 *  - findProductById(int id)
 *  - listAllProducts()
 *
 * Used by:
 *  - OrderManager (stock validation when placing an order)
 */


public class InventoryManager {

    private List<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // cuidado con NullPointerException después
    }

    public List<Product> listAllProducts() {
        return products;
    }

}
