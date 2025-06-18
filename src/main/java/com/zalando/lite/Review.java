package com.zalando.lite;

/**
 * Represents a review for a product by a customer.
 *
 * Fields:
 *  - int productId
 *  - int customerId
 *  - int rating (1-5)
 *  - String comment
 *
 * Used in:
 *  - ReviewManager
 */


public class Review {
    private int productId;
    private int customerId;
    private int rating; // de 1 a 5
    private String comment;

    public Review(int productId, int customerId, int rating, String comment) {
        this.productId = productId;
        this.customerId = customerId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getProductId() {
        return productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "productId=" + productId +
                ", customerId=" + customerId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }

}
