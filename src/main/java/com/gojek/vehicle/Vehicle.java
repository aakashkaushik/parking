package com.gojek.vehicle;

public abstract class Vehicle {

    public Vehicle(String registrationNumber, COLOR color, VEHICLE_TYPE vehicle_type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicle_type = vehicle_type;
    }

    public enum COLOR {
        RED("Red"), BLUE("Blue"), GREEN("Green"), BLACK("Black"), WHITE("White");

        private String color;

        COLOR(String color) {
            this.color = color;
        }
    }

    public enum VEHICLE_TYPE {
        TWO_WHEELER , FOUR_WHEELER
    }

    private String registrationNumber;
    private COLOR color;
    private VEHICLE_TYPE vehicle_type;

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color=" + color +
                ", vehicle_type=" + vehicle_type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return registrationNumber.equals(vehicle.registrationNumber) && color == vehicle.color && vehicle_type == vehicle.vehicle_type;
    }

    @Override
    public int hashCode() {
        int result = registrationNumber.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + vehicle_type.hashCode();
        return result;
    }
}
