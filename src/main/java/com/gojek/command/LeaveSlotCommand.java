package com.gojek.command;

import com.gojek.ParkingLotService;

public class LeaveSlotCommand implements Command {
    private ParkingLotService parkingLotService;
    private int slotNumber;

    public LeaveSlotCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.slotNumber = Integer.valueOf(args[1]);
    }

    public Object execute() {
        parkingLotService.leaveSlot(slotNumber);
        return "Slot number " + slotNumber + " is free";
    }
}
