package com.gojek;

import com.gojek.command.Command;
import org.junit.Test;

public class CommandInvoker {

    @Test
    public void testSampleInput(){
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandFactory commandFactory = new CommandFactory(parkingLotService);
        System.out.println(commandFactory.getCommand("create_parking_lot", new String[]{"","6"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-HH-1234", "White"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-HH-9999", "White"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-BB-0001", "Black"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-HH-7777", "Red"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-HH-2701", "Blue"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-HH-3141", "Black"}).execute());
        System.out.println(commandFactory.getCommand("leave", new String[]{"","4"}).execute());
        System.out.println(commandFactory.getCommand("status", null).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","KA-01-P-333", "White"}).execute());
        System.out.println(commandFactory.getCommand("park", new String[]{"","DL-12-AA-9999", "White"}).execute());
        System.out.println(commandFactory.getCommand("registration_numbers_for_cars_with_colour", new String[]{"","White"}).execute());
        System.out.println(commandFactory.getCommand("slot_numbers_for_cars_with_colour", new String[]{"","White"}).execute());
        System.out.println(commandFactory.getCommand("slot_number_for_registration_number", new String[]{"","KA-01-HH-3141"}).execute());
        System.out.println(commandFactory.getCommand("slot_number_for_registration_number", new String[]{"","MH-04-AY-1111"}).execute());
    }

}
