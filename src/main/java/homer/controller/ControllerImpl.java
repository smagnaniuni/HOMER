package homer.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import homer.DeviceInfoImpl;
import homer.api.Device;
import homer.api.DeviceId;
import homer.api.DeviceIdImpl;
import homer.api.DeviceView;
import homer.controller.command.Command;
import homer.controller.command.ConnectDevice;
import homer.controller.command.DisconnectAllDevices;
import homer.controller.command.DisconnectDevice;
import homer.controller.command.UpdateDeviceState;
import homer.model.lights.Light;
import homer.model.outlets.OutletFactory;

/**
 * Controller Implementation.
 */
public final class ControllerImpl implements Controller {

    private final Map<DeviceId, Device<?>> devices = new LinkedHashMap<>();
    private final List<Command> commands = new LinkedList<>();

    @Override
    public void connectDevice(final String deviceType) {
        final DeviceId device = new DeviceIdImpl();
        devices.put(device, new Light(new DeviceInfoImpl(device, deviceType), true));
    }

    @Override
    public void disconnectDevice(final DeviceId deviceId) {
        devices.remove(deviceId);
    }

    @Override
    public Set<DeviceView<?>> getDevices() {
        throw new UnsupportedOperationException("Unimplemented method 'getDevices'");
    }

    @Override
    public void receiveCommand(final Command command) {
        commands.add(command);
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod") // TODO fix
    private void execute(final Command command) {
        if (command instanceof ConnectDevice) {
            final ConnectDevice connect = (ConnectDevice) command;
            final String deviceType = connect.deviceType();
            final DeviceId deviceId = new DeviceIdImpl();
            devices.put(deviceId, OutletFactory.cOutlet(new DeviceInfoImpl(deviceId, deviceType), 0));
        } else if (command instanceof DisconnectDevice) {
            final DisconnectDevice remove = (DisconnectDevice) command;
            devices.remove(remove.deviceId());
        } else if (command instanceof DisconnectAllDevices) {
            devices.clear();
        } else if (command instanceof UpdateDeviceState) {
            final UpdateDeviceState updatestate = (UpdateDeviceState) command;
            final Device<?> targetDevice = devices.get(updatestate.deviceId());
            Object oldState = targetDevice.getState();
            // TODO cast and set state accordingly
        } else {
            throw new IllegalArgumentException();
        }
    }


}
