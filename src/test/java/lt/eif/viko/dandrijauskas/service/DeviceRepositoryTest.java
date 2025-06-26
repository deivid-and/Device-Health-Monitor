package lt.eif.viko.dandrijauskas.service;

import lt.eif.viko.dandrijauskas.model.Device;
import lt.eif.viko.dandrijauskas.model.HealthReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeviceRepositoryTest {
    private DeviceRepository repo;

    @BeforeEach
    void setUp() {
        repo = new DeviceRepository(); // create new repo before each test
    }

    @Test
    void testAddAndFindDevice() {
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

        repo.addDevice(device); // add device to repo

        assertEquals(1, repo.getAllDevices().size()); // check size is 1
        assertNotNull(repo.findDeviceById("TAB001")); // should find by id
        assertEquals("Tablet001", repo.findDeviceById("TAB001").get().getName()); // check name matches
    }

    @Test
    void testFindDeviceByIdNotFound() {
        assertFalse(repo.findDeviceById("NON_EXISTENT_ID").isPresent()); // should not find missing device
    }
}
