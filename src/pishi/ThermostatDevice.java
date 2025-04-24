package pishi;

public class ThermostatDevice extends Device {
    private int temperature;

    public ThermostatDevice(String name, Protocol protocol) {
        super(name, protocol);
    }

    @Override
    public String toString() {
        return String.format("thermostat:[name:%s , status:%s, temperature:%d]",
                getName(), getState(), temperature);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) throws IllegalArgumentException {
        if (temperature > 0 && temperature < 30)
            this.temperature = temperature;
        else
            throw new IllegalArgumentException("invalid value for temperature.");
    }
}