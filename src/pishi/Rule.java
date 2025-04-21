package pishi;

import java.util.Objects;

public record Rule(String deviceName, String time, String action) {

    @Override
    public String toString() {
        return "Rule [deviceName=" + deviceName + ", time=" + time + ", action=" + action + ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Rule rule = (Rule) obj;
        return rule.deviceName.equals(this.deviceName) && rule.time.equals(this.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceName, time);
    }
}
