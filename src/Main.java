import pishi.Device;

import java.util.Scanner;

public class Main {
    public static Scanner sca = new Scanner(System.in);
    public static void main(String[] args) {
        int q = sca.nextInt();
        while (q != 0) {
            String command = sca.nextLine();
            switch (command.split(" ")[0]) {
                case "add_device" -> handleAddDevice();
                case "set_device" -> handleSetDevice();
                case "remove_device" -> handleRemoveDevice();
                case "list_devices" -> handleListDevices();
                case "add_rule" -> handleAddRule();
                case "check_rules" -> handleCheckRules();
                case "list_rules" -> handleListRules();
            }
            q--;
        }
    }

    public static void handleAddDevice() {

    }

    public static void handleSetDevice() {}

    public static void handleRemoveDevice() {}

    public static void handleListDevices() {}

    public static void handleAddRule() {}

    public static void handleCheckRules() {}

    public static void handleListRules() {}
}