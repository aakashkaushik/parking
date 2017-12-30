package com.gojek.command;

import com.gojek.ParkingLotService;
import com.gojek.Slot;

public class SlotNumberByRegistrationNumberCommand implements Command {
    private ParkingLotService parkingLotService;
    private String registrationNumber;

    public SlotNumberByRegistrationNumberCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.registrationNumber = args[1];
    }

    public Object execute() {
        Slot slot = parkingLotService.getSlotByVehicleRegNo(registrationNumber);
        if (slot == null)
            return "Not Found";
        else
            return slot.getNumber();
    }
}
