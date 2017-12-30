package com.gojek.vehicle;

public class Car extends Vehicle{

    public Car(String registrationNumber, COLOR color) {
        super(registrationNumber, color, VEHICLE_TYPE.FOUR_WHEELER);
    }

}
