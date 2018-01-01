package com.gojek;

import org.junit.Assert;
import org.junit.Test;

public class LeaveCommandTest {

    @Test
    public void createParkingLotAndParkVehicleAndLeaveTest() {
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandFactory commandFactory = new CommandFactory(parkingLotService);
        int noOfSlots = 6;
        commandFactory.getCommand(new String[]{"create_parking_lot", String.valueOf(noOfSlots)}).execute();
        commandFactory.getCommand(new String[]{"park", "KA-01-HH-1234", "White"}).execute();
        Assert.assertEquals("", "Slot number 1 is free", commandFactory.getCommand(new String[]{"leave", "1"}).execute());
    }
}
