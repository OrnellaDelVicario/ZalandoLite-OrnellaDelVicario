package com.zalando.lite;

import java.time.LocalDateTime;

public class Delivery {
    private int deliveryId;
    private Order order;
    private Courier courier;
    private String status; // Ej: "Assigned", "In Transit", "Delivered", "Failed"
    private LocalDateTime timestamp;

    public Delivery(int deliveryId, Order order, Courier courier) {
        this.deliveryId = deliveryId;
        this.order = order;
        this.courier = courier;
        this.status = "Assigned";
        this.timestamp = LocalDateTime.now();
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public Order getOrder() {
        return order;
    }

    public Courier getCourier() {
        return courier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + deliveryId +
                ", courier=" + (courier != null ? courier.getName() : "None") +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                ", orderId=" + order.getId() +
                '}';

    }
}
