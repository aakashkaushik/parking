package com.gojek;

import com.gojek.command.*;

public class CommandFactory {
    public Command command;
    private ParkingLotService parkingLotService;

    public CommandFactory(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public Command getCommand(String[] args) {
        CommandName commandName = CommandName.valueOf(args[0].toUpperCase());
        switch (commandName) {
            case CREATE_PARKING_LOT:
                command = new CreateSlotCommand(parkingLotService, args);
                break;
            case PARK:
                command = new ParkVehicleCommand(parkingLotService, args);
                break;
            case LEAVE:
                command = new LeaveSlotCommand(parkingLotService, args);
                break;
            case STATUS:
                command = new StatusCommand(parkingLotService, args);
                break;
            case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
                command = new VehicleInfoByColorCommand(parkingLotService, args);
                break;
            case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                command = new SlotInfoByColorCommand(parkingLotService, args);
                break;
            case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                command = new SlotInfoByRegistrationCommand(parkingLotService, args);
                break;
        }
        return command;
    }
}
