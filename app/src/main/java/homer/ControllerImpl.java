package homer;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import homer.api.Controller;
import homer.api.Device;
import homer.api.DeviceView;

public class ControllerImpl implements Controller {

    private final Set<Device<?>> devices = new HashSet<>();

    @Override
    public void connectDevice(Device<?> device) {
        this.devices.add(device);
    }

    // @Override
    // public Set<Device<?>> getDevices() {
    // return Set.copyOf(this.devices);
    // }

    @Override
    public Set<DeviceView<?>> getDevices() {
        return this.devices.stream()
                .map(d -> new DeviceView<String>() {

                    @Override
                    public String getState() {
                        return "template " + d.getState().toString();
                    }

                })
                .collect(Collectors.toSet());

    }

    @Override
    public void updateDevice(DeviceView<?> device) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDevice'");
    }

}
