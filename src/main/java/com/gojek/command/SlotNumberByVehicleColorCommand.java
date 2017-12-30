package com.gojek.command;

import com.gojek.ParkingLotService;
import com.gojek.Slot;

import java.util.List;

public class SlotNumberByVehicleColorCommand implements Command {
    private ParkingLotService parkingLotService;
    private String vehileColor;

    public SlotNumberByVehicleColorCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
        this.vehileColor = args[1];
    }

    public Object execute() {
        List<Slot> slots = parkingLotService.getSlotsByVehicleColor(vehileColor);
        if (slots.isEmpty())
            return "Not Found";
        return slots;
    }
}
