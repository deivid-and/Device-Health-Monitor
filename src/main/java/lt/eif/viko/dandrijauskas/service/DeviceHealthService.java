package lt.eif.viko.dandrijauskas.service;

import lt.eif.viko.dandrijauskas.model.Device;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * soap web service interface for device health.
 */

@WebService
public interface DeviceHealthService {

    @WebMethod
    void addDevice(Device device);

    @WebMethod
    List<Device> getAllDevices();

    @WebMethod
    Device getDeviceById(String deviceId);
}
