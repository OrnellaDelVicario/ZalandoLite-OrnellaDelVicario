package com.zalando.lite;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private Map<Integer, Customer> customers;

    public CustomerManager() {
        this.customers = new HashMap<>();
    }

    public void registerCustomer(Customer c) {
        customers.put(c.getId(), c);
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }
}
