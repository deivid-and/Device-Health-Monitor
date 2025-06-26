package lt.eif.viko.dandrijauskas.model;

import java.time.LocalDateTime;

// single health report entry for a device.

public class HealthReport {
    private String timestamp;
    private String status;      // OK, WARN, FAIL
    private String message;
    private float temperature;
    private float batteryLevel;

    public HealthReport(String timestamp, String status, String message, float temperature, float batteryLevel) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.temperature = temperature;
        this.batteryLevel = batteryLevel;
    }

    public HealthReport() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(float batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
