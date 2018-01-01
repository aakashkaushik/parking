package com.gojek;

import org.junit.Assert;
import org.junit.Test;

public class ParkCommandTest {

    @Test
    public void createParkingLotAndParkVehicleTest() {
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandFactory commandFactory = new CommandFactory(parkingLotService);
        int noOfSlots = 6;
        commandFactory.getCommand(new String[]{"create_parking_lot", String.valueOf(noOfSlots)}).execute();
        Assert.assertEquals("", "Allocated slot number: 1", commandFactory.getCommand(new String[]{"park", "KA-01-HH-1234", "White"}).execute());
    }
}
