package com.zalando.lite;

public class Payment {

       private int id;
       private int orderId;
       private double amount;
       private String  paymentMethod;
       private Boolean isSuccessful;

    public Payment(int id, int orderId, double amount, String paymentMethod) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isSuccessful = validatePayment(paymentMethod);
    }

    private boolean validatePayment(String method) {
      return method.equalsIgnoreCase("CASH") || method.equalsIgnoreCase("CARD");

    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Boolean isSuccessful() {
        return isSuccessful;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", isSuccessful=" + isSuccessful +
                '}';
    }

}
