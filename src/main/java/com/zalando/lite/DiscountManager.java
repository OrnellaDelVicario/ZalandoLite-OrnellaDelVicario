package com.zalando.lite;

import java.lang.reflect.Field;

/**
 * Applies discounts to products or orders.
 *
 * Logic:
 *  - 10% off for VIP customers
 *  - 5% off for category matches with customer favorites
 *
 * Method:
 *  - applyDiscount(Customer, Product, double price)
 */


public class DiscountManager {
    public double applyDiscount(Customer customer, Product product, double originalPrice){
        double price = originalPrice;

        if (isVipViaReflection(customer)){
            price *= 0.9;
        }
        if ("Shoes".equalsIgnoreCase(product.getCategory())){
            price *= 0.8;
        }
        return price;
    }

    private boolean isVipViaReflection(Customer customer){
        try{
            for(Field field: customer.getClass().getDeclaredFields()){
                if (field.isAnnotationPresent(VIP.class)){
                    field.setAccessible(true);
                    return (boolean) field.get(customer);
                }
            }
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return false;
    }

}