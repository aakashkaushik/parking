package com.gojek;

import com.gojek.command.*;

public class CommandFactory {
    public Command command;
    private ParkingLotService parkingLotService;

    public CommandFactory(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public Command getCommand(String[] args) {
        String commandName = args[0];
        switch (commandName) {
            case "create_parking_lot":
                command = new CreateSlotCommand(parkingLotService, args);
                break;
            case "park":
                command = new ParkVehicleCommand(parkingLotService, args);
                break;
            case "leave":
                command = new LeaveSlotCommand(parkingLotService, args);
                break;
            case "status":
                command = new StatusCommand(parkingLotService, args);
                break;
            case "registration_numbers_for_cars_with_colour":
                command = new VehicleInfoByColorCommand(parkingLotService, args);
                break;
            case "slot_numbers_for_cars_with_colour":
                command = new SlotInfoByColorCommand(parkingLotService, args);
                break;
            case "slot_number_for_registration_number":
                command = new SlotInfoByRegistrationCommand(parkingLotService, args);
                break;
        }
        return command;
    }
}
