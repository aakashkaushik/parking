package com.gojek.command;

import com.gojek.ParkingLotService;
import com.gojek.vehicle.Vehicle;

import java.util.List;

public class VehicleInfoByColorCommand implements Command {
    private ParkingLotService parkingLotService;
    private String vehicleColor;

    public VehicleInfoByColorCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.vehicleColor = args[1];
    }

    public Object execute() {
        List<Vehicle> vehicles = parkingLotService.getVehicleInfoByColor(vehicleColor);
        if (vehicles.isEmpty())
            return "Not found";
        StringBuilder stringBuilder = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            stringBuilder.append(vehicle.getRegistrationNumber()).append(" , ");
        }
        return stringBuilder.toString();
    }
}
