package pishi;

public class LightDevice extends Device {
    private int brightness;

    public LightDevice(String name, Protocol protocol) {
        super(name, protocol);
        brightness = 0;
    }

    @Override
    public String toString() {
        return String.format("Device:[name:%s , protocol:%s, type:Light", getName(), getProtocol());
    }
}
