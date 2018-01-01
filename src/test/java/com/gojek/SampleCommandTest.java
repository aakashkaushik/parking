package com.gojek;

import org.junit.Test;

public class SampleCommandTest {

    @Test
    public void sampleInputTest() {
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandFactory commandFactory = new CommandFactory(parkingLotService);
        System.out.println(commandFactory.getCommand(new String[]{"create_parking_lot", "6"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-HH-1234", "White"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-HH-9999", "White"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-BB-0001", "Black"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-HH-7777", "Red"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-HH-2701", "Blue"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-HH-3141", "Black"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"leave", "4"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"status"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "KA-01-P-333", "White"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"park", "DL-12-AA-9999", "White"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"registration_numbers_for_cars_with_colour", "White"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"slot_numbers_for_cars_with_colour", "White"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"slot_number_for_registration_number", "KA-01-HH-3141"}).execute());
        System.out.println(commandFactory.getCommand(new String[]{"slot_number_for_registration_number", "MH-04-AY-1111"}).execute());
    }
}
