package lt.eif.viko.dandrijauskas.service;

import lt.eif.viko.dandrijauskas.model.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * handles device storage and lookup.
 */

public class DeviceRepository {
    private final List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Device> getAllDevices() {
        return new ArrayList<>(devices);
    }

    public Optional<Device> findDeviceById(String deviceId) {
        return devices.stream()
                .filter(device -> device.getDeviceId().equals(deviceId))
                .findFirst();
    }
}
