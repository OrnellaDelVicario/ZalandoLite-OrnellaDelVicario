package com.zalando.lite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages product reviews from customers.
 *
 * Responsibilities:
 *  - Add reviews
 *  - Retrieve reviews per product
 *
 * Methods:
 *  - addReview(Review)
 *  - getReviewsForProduct(int productId)
 */

public class ReviewManager {
    // Mapea productId → lista de reseñas
    private Map<Integer, List<Review>> reviewsByProduct;

    public ReviewManager() {
        this.reviewsByProduct = new HashMap<>();
    }

    public void addReview(Review review) {
        int productId = review.getProductId();
        reviewsByProduct.putIfAbsent(productId, new ArrayList<>());
        reviewsByProduct.get(productId).add(review);
        System.out.println("Review added for product " + productId);
    }

    public List<Review> getReviewsForProduct(int productId) {
        return reviewsByProduct.getOrDefault(productId, new ArrayList<>());
    }
}
