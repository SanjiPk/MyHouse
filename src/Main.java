import Validator.ActionValidator;
import Validator.TimeValidator;
import exceptions.DeviceNotFoundException;
import exceptions.DuplicateElementException;
import exceptions.InvalidActionException;
import exceptions.InvalidTimeException;
import pishi.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int q = sca.nextInt();
        while (q > -1) {
            String command = sca.nextLine();
            String[] info = command.split(" ");
            switch (info[0]) {
                case "add_device" -> handleAddDevice(command);
                case "set_device" -> handleSetDevice(command);
                case "remove_device" -> handleRemoveDevice(command);
                case "list_devices" -> handleListDevices();
                case "add_rule" -> handleAddRule(command);
                case "check_rules" -> handleCheckRules(command);
                case "list_rules" -> handleListRules();
            }
            q--;
        }
    }

    public static void handleAddDevice(String command) {
        String[] information = command.split(" ");
        Protocol protocol = (information[3].equalsIgnoreCase("wifi")) ?
                Protocol.WIFI : Protocol.BLUETOOTH;
        try {
            if (information[1].equalsIgnoreCase("light"))
                DeviceManager.addDevice(new LightDevice(information[2], protocol));
            else
                DeviceManager.addDevice(new ThermostatDevice(information[2], protocol));
            System.out.println("Device added successfully");
        } catch (DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleSetDevice(String command) {
        String[] information = command.split(" ");
        ActionValidator validator = new ActionValidator();

        try {
            validator.validate(information[3]);
        } catch (InvalidActionException e) {
            System.out.println(e.getMessage());
        }

        Device device = null;
        try {
            device = DeviceManager.findDevice(information[1]);


            if (information[2].equals("status")) {
                if (information[3].equals("on"))
                    device.turnOn();
                else device.turnOff();
            }

            if (information[2].equals("brightness")) {
                if (device.getClass().equals(LightDevice.class)) {
                    ((LightDevice) device).setBrightness(Integer.parseInt(information[3]));
                }
                else System.out.println("invalid property");
            } else if (information[2].equals("temperature")) {
                ((ThermostatDevice) device).setTemperature(Integer.parseInt(information[3]));
            } else System.out.println("invalid property");
            System.out.println("device updated successfully.");
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {

        }
    }

    public static void handleRemoveDevice(String command) {
        String[] info = command.split(" ");
        try {
            DeviceManager.removeDevice(info[1]);
            System.out.println("device removed successfully");
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleListDevices() {
        DeviceManager.listDevices();
    }

    public static void handleAddRule(String command) {
        String[] information = command.split(" ");
        try {
            DeviceManager.contain(information[1]);
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        TimeValidator tValidator = new TimeValidator();
        try {
            tValidator.validate(information[2]);
        } catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }

        ActionValidator actionValidator = new ActionValidator();
        try {
            actionValidator.validate(information[3]);
        } catch (InvalidActionException e) {
            System.out.println(e.getMessage());
        }

        Rule rule = new Rule(information[1], information[2], information[3]);
        try {
            DeviceManager.addRule(rule);
        } catch (DuplicateElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("rule added successfully.");
    }

    public static void handleCheckRules(String command) {
        String[] info = command.split(" ");
        TimeValidator validator = new TimeValidator();
        try {
            validator.validate(info[1]);
        } catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
        DeviceManager.checkRule(info[1]);

        System.out.println("rules checked");
    }

    public static void handleListRules() {
        DeviceManager.listRules();
    }
}