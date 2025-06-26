package lt.eif.viko.dandrijauskas;

import lt.eif.viko.dandrijauskas.service.DeviceHealthServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:8080/devicehealth";
        Endpoint.publish(url, new DeviceHealthServiceImpl());
        System.out.println("DeviceHealthService published at " + url);
    }
}
