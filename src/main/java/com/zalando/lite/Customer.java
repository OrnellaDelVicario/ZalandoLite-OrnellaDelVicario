package com.zalando.lite;

import java.util.List;

/**
 * Represents a customer of the ZalandoLite platform.
 *
 * Fields:
 *  - int customerId
 *  - String name
 *  - String email
 *  - List<String> favoriteCategories
 *  - boolean isVip (used for discounts via reflection)
 *
 * Used in:
 *  - CustomerManager
 *  - DiscountManager
 *  - Order
 *  - Review
 */


public class Customer {
    private int customerId;
    private String name;
    private String email;
    private List<String> favoriteCategories;

    //@VIP
    private boolean isVip;

    public Customer(int id, String name, String email, List<String> favoriteCategories, boolean isVip) {
        this.customerId = id;
        this.name = name;
        this.email = email;
        this.favoriteCategories = favoriteCategories;
        this.isVip = isVip;
    }

    public int getId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<String> getFavoriteCategories() { return favoriteCategories; }
    public boolean isVip() { return isVip; }

    public void setId(int id) { this.customerId = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setFavoriteCategories(List<String> favoriteCategories) { this.favoriteCategories = favoriteCategories; }
    public void setVip(boolean vip) { isVip = vip; }
}
