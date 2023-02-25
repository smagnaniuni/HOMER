package homer;

import homer.api.Device;
import homer.api.DeviceInfo;

public class Thermometer implements Device<Double> {

    private static final long ID = 0;
    private static final String TYPE = "Thermometer";
    private final Double state = 15.0;

    @Override
    public DeviceInfo getInfo() {
        return new DeviceInfo() {

            @Override
            public long getID() {
                return ID;
            }

            @Override
            public String getType() {
                return TYPE;
            }

        };
    }

    @Override
    public Double getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return "Device [" + getInfo().getID() + ", " + getInfo().getType() + ", " + state + "]";
    }

}
