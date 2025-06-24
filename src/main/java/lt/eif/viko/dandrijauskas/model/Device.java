package lt.eif.viko.dandrijauskas.model;

import java.util.List;

// monitored device.

public class Device {
    private String deviceId;
    private String name;
    private String type;
    private float batteryLevel;
    private boolean online;
    private char status; // 'O' for OK, 'W' for Warning, 'F' for Fail
    private List<HealthReport> healthReports;

    public Device() {
    }

    public Device(String deviceId, String name, String type, float batteryLevel, boolean online, char status, List<HealthReport> healthReports) {
        this.deviceId = deviceId;
        this.name = name;
        this.type = type;
        this.batteryLevel = batteryLevel;
        this.online = online;
        this.status = status;
        this.healthReports = healthReports;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(float batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public List<HealthReport> getHealthReports() {
        return healthReports;
    }

    public void setHealthReports(List<HealthReport> healthReports) {
        this.healthReports = healthReports;
    }
}
