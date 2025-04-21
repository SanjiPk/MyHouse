package pishi;

public class ThermostatDevice extends Device {
    public ThermostatDevice(String name, Protocol protocol) {
        super(name, protocol);
    }

    @Override
    public String toString() {
        return String.format("Device:[name:%s , protocol:%s, type:thermostat",
                getName(), getProtocol());
    }
}
