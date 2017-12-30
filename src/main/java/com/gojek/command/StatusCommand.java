package com.gojek.command;

import com.gojek.ParkingLotService;
import com.gojek.Slot;
import com.gojek.vehicle.Vehicle;

import java.util.Map;

public class StatusCommand implements Command {
    private ParkingLotService parkingLotService;

    public StatusCommand(ParkingLotService parkingLotService, String[] args) {
        this.parkingLotService = parkingLotService;
    }

    public Object execute() {
        Map<Slot, Vehicle> slotVehicleMap = parkingLotService.getSlotVehicleMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Slot No \t Registration No. \t Colour \n");
        for (Map.Entry<Slot, Vehicle> entry : slotVehicleMap.entrySet()) {
            if (entry.getValue() != null) {
                stringBuilder.append(entry.getKey().getNumber()).append("\t")
                        .append(entry.getValue().getRegistrationNumber()).append("\t")
                        .append(entry.getValue().getColor().name()).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
