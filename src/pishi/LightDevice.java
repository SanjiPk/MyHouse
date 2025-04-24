package pishi;

public class LightDevice extends Device {
    private int brightness;

    public LightDevice(String name, Protocol protocol) {
        super(name, protocol);
    }

    @Override
    public String toString() {
        return String.format("light:[name:%s , status:%s, brightness:%d]",
                getName(), getState(), brightness);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) throws IllegalArgumentException{
        if (brightness > 0 && brightness < 100)
            this.brightness = brightness;
        else throw new IllegalArgumentException("invalid value for brightness.");
    }
}