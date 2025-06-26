package lt.eif.viko.dandrijauskas.service;

import lt.eif.viko.dandrijauskas.model.Device;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "lt.eif.viko.dandrijauskas.service.DeviceHealthService")
public class DeviceHealthServiceImpl implements DeviceHealthService {

    private final DeviceRepository repository = new DeviceRepository();

    @Override
    public void addDevice(Device device) {
        repository.addDevice(device);
    }

    @Override
    public List<Device> getAllDevices() {
        return repository.getAllDevices();
    }

    @Override
    public Device getDeviceById(String deviceId) {
        return repository.findDeviceById(deviceId).orElse(null);
    }
}
