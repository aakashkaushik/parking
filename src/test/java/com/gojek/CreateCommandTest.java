package com.gojek;

import org.junit.Assert;
import org.junit.Test;

public class CreateCommandTest {

    @Test
    public void createTest() {
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandFactory commandFactory = new CommandFactory(parkingLotService);
        int noOfSlots = 6;
        Assert.assertEquals("", "Created a parking lot with "+noOfSlots+" slots", commandFactory.getCommand(new String[]{"create_parking_lot", String.valueOf(noOfSlots)}).execute());
    }


}
