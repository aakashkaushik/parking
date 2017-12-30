package com.gojek.command;

import com.gojek.ParkingLotService;

public class CreateSlotCommand implements Command {
    private ParkingLotService parkingLotService;
    private int noOfSlots;

    public CreateSlotCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.noOfSlots = Integer.valueOf(args[1]);
    }

    public Object execute() {
        parkingLotService.initializeSlots(noOfSlots);
        return "Created a parking lot with " + noOfSlots + " slots";
    }
}
