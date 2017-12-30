package com.gojek.vehicle;

public abstract class Vehicle {

    public enum COLOR {
        RED, BLUE, GREEN, BLACK;
    }

    public enum VEHICLE_TYPE {
        TWO_WHEELER , FOUR_WHEELER ;
    }

    String registrationNumber;
    COLOR color;
    VEHICLE_TYPE vehicle_type;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

}
