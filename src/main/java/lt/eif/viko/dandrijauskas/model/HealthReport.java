package lt.eif.viko.dandrijauskas.model;

import java.time.LocalDateTime;

// single health report entry for a device.

public class HealthReport {
    private LocalDateTime timestamp;
    private String status;      // OK, WARN, FAIL
    private String message;
    private float temperature;
    private float batteryLevel;

    public HealthReport() {
    }

    public HealthReport(LocalDateTime timestamp, String status, String message, float temperature, float batteryLevel) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.temperature = temperature;
        this.batteryLevel = batteryLevel;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
