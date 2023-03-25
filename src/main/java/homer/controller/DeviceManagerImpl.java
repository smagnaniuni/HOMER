package homer.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import homer.api.Device;
import homer.api.DeviceId;
import homer.api.DeviceIdImpl;
import homer.api.ToggleableDevice;
import homer.common.temperature.Temperature;
import homer.common.temperature.TemperatureFactory;
import homer.controller.command.createdevicecommand.CreateAirConditioning;
import homer.controller.command.createdevicecommand.CreateDeviceCommand;
import homer.controller.command.createdevicecommand.CreateHeating;
import homer.model.airquality.AirQualityState;
import homer.model.airquality.AirQualityStateFactory;
import homer.model.environment.Environment;
import homer.model.environment.HomeEnvironment;

/**
 * DeviceManager implementation.
 */
public final class DeviceManagerImpl implements DeviceManager {
    private final Map<DeviceId, Device<?>> deviceMap = new LinkedHashMap<>();
    private final Temperature temperature = TemperatureFactory.fromCelsius(0);
    private final AirQualityState airQualityState = AirQualityStateFactory.normalAirQuality();
    private final Environment environment = new HomeEnvironment(temperature, airQualityState);

    @Override
    public void createDevice(final String deviceType) {

    }

    @Override
    public void removeAllDevices() {
        this.deviceMap.clear();
    }

    @Override
    public boolean isDeviceConnected(final DeviceId deviceId) {
        return deviceMap.containsKey(deviceId);
    }

    @Override
    public void removeDevice(final DeviceId deviceId) {
        if (this.isDeviceConnected(deviceId)) {
            deviceMap.remove(deviceId);
        }
    }

    @Override
    public void toggleDevice(final DeviceId deviceId) {
        final Device<?> targetDevice = deviceMap.get(deviceId);
        if (targetDevice instanceof ToggleableDevice) {
            final ToggleableDevice<?> toggleableDevice = (ToggleableDevice<?>) targetDevice;
            toggleableDevice.toggle();
        } else {
            throw new IllegalArgumentException("Device is not toggleable");
        }

    }

    @Override
    public void addDevice(Device<?> device) {
        this.deviceMap.put(new DeviceIdImpl(), device);
    }

    @Override
    public Set<CreateDeviceCommand> getValidCreateDeviceCommands() {
        return Set.of(new CreateAirConditioning(this.environment), new CreateHeating(this.environment));
    }


}
