package com.gojek;

import com.gojek.command.Command;

import java.io.*;

public class ParkingLotApplication {

    public static CommandFactory commandFactory = null;
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        commandFactory = new CommandFactory(parkingLotService);
        switch (args.length) {
            case 0:
                System.out.println("Please enter 'exit' to quit");
                System.out.println("Waiting for input...");
                // Interactive command-line input/output
                // Run an infinite loop
                for (; ; ) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                            parseTextInput(inputString.trim());
                        }
                    } catch (IOException e) {
                        System.out.println("Exception in reading input");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                // File input/output
                parseFileInput(args[0]);
                break;
            default:
                System.out.println(" Invalid input. Format :: java -jar <jar_file_path> <input_file_path> ");
        }

    }



    public static void parseTextInput(String inputString) {
        // Split the input string to get command and input value
        String[] inputs = inputString.split(" ");
        Command command = commandFactory.getCommand(inputs);
        if (command == null) {
            System.out.println("Incorrect Input");
        } else
            System.out.println(command.execute());
    }

    public static void parseFileInput(String filePath) {
        // Assuming input to be a valid file path.
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseTextInput(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }
}
