package pishi;

import exceptions.DeviceNotFoundException;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Device {
    private String name;
    private Protocol protocol;
    private boolean state;

    public Device(String name, Protocol protocol) {
        setName(name);
        setProtocol(protocol);
    }

    public void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }

    public boolean getState() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return Objects.equals(((Device) obj).name, this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}
