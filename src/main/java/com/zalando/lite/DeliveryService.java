package com.zalando.lite;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    private List<Courier> couriers;
    private List<Delivery> deliveries;

    public DeliveryService() {
        this.couriers = new ArrayList<>();
        this.deliveries = new ArrayList<>();
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public Delivery assignCourierToOrder(Order order) {
        for (Courier courier : couriers) {
            if (courier.isAvailable()) {
                courier.toggleAvailability(); // Ocupado
                Delivery delivery = new Delivery(deliveries.size() + 1, order, courier);
                deliveries.add(delivery);
                System.out.println("Courier assigned: " + courier.getName());
                return delivery;
            }
        }

        System.out.println("No couriers available. Delivery pending.");
        Delivery delivery = new Delivery(deliveries.size() + 1, order, null);
        delivery.setStatus("Pending");
        deliveries.add(delivery);
        return delivery;
    }

    public void updateDeliveryStatus(Delivery delivery, String newStatus) {
        delivery.setStatus(newStatus);
        System.out.println("Delivery " + delivery.getDeliveryId() + " updated to: " + newStatus);

        // Si se completó, liberar courier
        if (newStatus.equalsIgnoreCase("Delivered") && delivery.getCourier() != null) {
            delivery.getCourier().toggleAvailability();
        }
    }

    public List<Delivery> getAllDeliveries() {
        return deliveries;
    }
}
