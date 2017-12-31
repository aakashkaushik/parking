package com.gojek.command;

import com.gojek.ParkingLotService;
import com.gojek.Slot;

import java.util.List;

public class SlotInfoByColorCommand implements Command {
    private ParkingLotService parkingLotService;
    private String vehicleColor;

    public SlotInfoByColorCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.vehicleColor = args[1];
    }

    public Object execute() {
        List<Slot> slots = parkingLotService.getSlotsByVehicleColor(vehicleColor);
        if (slots.isEmpty())
            return "Not Found";
        return slots;
    }
}
