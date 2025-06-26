package lt.eif.viko.dandrijauskas.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * wrapper class for a list of devices for xml export.
 */

@XmlRootElement(name = "devices")
public class DevicesList {
    private List<Device> devices;

    @XmlElement(name = "device")
    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
