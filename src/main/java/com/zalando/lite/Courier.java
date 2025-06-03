package com.zalando.lite;

public class Courier {
    private int id;
    private String name;
    private String vehicleType;
    private boolean isAvailable;

    public Courier(int id, String name, String vehicleType) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.isAvailable = true; // Por defecto, disponible
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void toggleAvailability() {
        this.isAvailable = !this.isAvailable;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }


}
