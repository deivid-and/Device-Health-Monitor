package lt.eif.viko.dandrijauskas;

import lt.eif.viko.dandrijauskas.model.Device;
import lt.eif.viko.dandrijauskas.model.HealthReport;
import lt.eif.viko.dandrijauskas.service.DeviceHealthServiceImpl;
import lt.eif.viko.dandrijauskas.util.XmlTransformer;

import javax.xml.ws.Endpoint;
import java.util.Arrays;

/**
 * starts the soap service and runs xml/html/pdf exports.
 */


public class Main {
    public static void main(String[] args) {
        // start soap web service
        String url = "http://localhost:8080/devicehealth";
        Endpoint.publish(url, new DeviceHealthServiceImpl());
        System.out.println("DeviceHealthService published at " + url);

        // make xml transformer
        XmlTransformer transformer = new XmlTransformer();

        // create example data
        HealthReport report = new HealthReport(
                "2025-04-24T05:30:00",
                "OK",
                "Normal operation",
                36.2f,
                77.0f
        );
        Device device = new Device(
                "TAB001",
                "Tablet001",
                "Office Device",
                77.0f,
                true,
                'O',
                Arrays.asList(report)
        );

        // export device data to xml
        transformer.exportDevicesToXml(
                Arrays.asList(device),
                "src/main/resources/sample_device_health.xml"
        );

        System.out.println("Sample device health XML exported.");

        // make html report from xml
        transformer.transformXmlToHtml(
                "src/main/resources/sample_device_health.xml",
                "src/main/resources/device_health.xsl",
                "src/main/resources/device_health.html"
        );

        // make pdf report from xml
        transformer.transformXmlToPdf(
                "src/main/resources/sample_device_health.xml",
                "src/main/resources/device_health_fo.xsl",
                "src/main/resources/device_health.pdf"
        );

    }
}
