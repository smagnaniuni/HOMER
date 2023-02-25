package homer;

import homer.api.DeviceInfo;
import homer.api.ToggleableDevice;

public class Lock implements ToggleableDevice<LockState> {

    private static final long ID = 0;
    private static final String TYPE = "Lock";
    private final LockState state = new LockState();

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
    public LockState getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return "Device [" + getInfo().getID() + ", " + getInfo().getType() + ", " + state.isLocked() + "]";
    }

    @Override
    public boolean isToggled() {
        return this.state.isLocked();
    }

    @Override
    public void toggle() {
        if (this.state.isLocked()) {
            this.state.unlock();
        } else {
            this.state.lock();
        }
    }

}
