package com.zalando.lite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes delivery data to a file.
 *
 * Responsibilities:
 *  - Generate delivery reports (e.g. for admin)
 *
 * Method:
 *  - writeToFile(List<Delivery>, String filename)
 */


public class ReportManager {

    public void writeToFile(List<Delivery> deliveries, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Delivery delivery : deliveries) {
                String line = "Order ID: " + delivery.getOrder().getId() +
                        ", Courier: " + delivery.getCourier().getName() +
                        ", Status: " + delivery.getStatus();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ Delivery report written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("⚠️ Error writing to file: " + e.getMessage());
        }
    }
}
