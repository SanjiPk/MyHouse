package pishi;

import exceptions.DeviceNotFoundException;
import exceptions.DuplicateElementException;
import exceptions.RuleNotFoundException;

import java.util.ArrayList;

public class DeviceManager {
    private static final ArrayList<Device> devices = new ArrayList<>();
    private static final ArrayList<Rule> rules = new ArrayList<>();

    private DeviceManager() {
    }

    public static void addDevice(Device device) {
        if (devices.contains(device))
            throw new DuplicateElementException("");
        devices.add(device);
    }

    public static Device findDevice(Device device) {
        for (Device dev : devices)
            if (dev.equals(device))
                return dev;
        throw new DeviceNotFoundException(device.getName() + "not found.");
    }

    public static Device findDevice(String deviceName) {
        for (Device device : devices) {
            if (device.getName().equals(deviceName)) {
                return device;
            }
        }
        throw new DeviceNotFoundException(deviceName + "not exist.");
    }

    public static void removeDevice(Device device) {
        if (!devices.contains(device)) {
            throw new DeviceNotFoundException(device.getName() + "not found to delete.");
        }
        devices.remove(device);
    }

    public static void removeDevice(String deviceName) {
        boolean isRemoved = devices.removeIf(device -> device.getName().equals(deviceName));
        if (!isRemoved)
            throw new DeviceNotFoundException(deviceName + "not found to delete.");
    }

    public static void listDevices() {
        if (devices.isEmpty()) {
            System.out.println();
        }
        for (Device device : devices) {
            System.out.println(device.toString());
        }
    }

    public static boolean contain(String deviceName) {
        for (Device device : devices) {
            if (device.getName().equals(deviceName)) {
                return true;
            }
        }
        return false;
    }

    public static void addRule(Rule rule) {
        if (rules.contains(rule))
            throw new DuplicateElementException("");
        rules.add(rule);
    }

    public static Rule findRule(Rule rule) {
        for (Rule r : rules) {
            if (r.equals(rule))
                return r;
        }
        throw new RuleNotFoundException("Rule for " + rule.deviceName() + " at " + rule.time() + " not found.");
    }

    public static void removeRule(Rule rule) {
        if (!rules.remove(rule)) {
            throw new RuleNotFoundException("Rule for " + rule.deviceName() + " at " + rule.time() + " not found to delete.");
        }
    }

    public static void listRules() {
        if (rules.isEmpty()) {
            System.out.println();
            return;
        }
        for (Rule rule : rules) {
            System.out.println(rule.toString());
        }
    }

    public static boolean containRule(Rule rule) {
        for (Rule r : rules) {
            if (r.equals(rule)) {
                return true;
            }
        }
        return false;
    }
}
