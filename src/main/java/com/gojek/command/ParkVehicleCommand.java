package com.gojek.command;

import com.gojek.ParkingException;
import com.gojek.ParkingLotService;
import com.gojek.Slot;
import com.gojek.vehicle.Car;
import com.gojek.vehicle.Vehicle;

public class ParkVehicleCommand implements Command {

    private ParkingLotService parkingLotService;
    private String registrationNumber;
    private String vehicleColor;

    public ParkVehicleCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.registrationNumber = args[1];
        this.vehicleColor = args[2];
    }

    public Object execute() {
        Slot slot = parkingLotService.getFreeSlot();
        if (slot == null)
            return "Sorry, parking lot is full" ;
        slot.setOccupied(true);
        Vehicle vehicle = new Car(registrationNumber, Vehicle.COLOR.valueOf(vehicleColor.toUpperCase()));
        parkingLotService.parkVehicle(slot, vehicle);
        return "Allocated slot number: " + slot.getNumber();
    }
}
