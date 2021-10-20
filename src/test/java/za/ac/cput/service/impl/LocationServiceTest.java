package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Location;

import za.ac.cput.factory.LocationFactory;
;

import static org.junit.jupiter.api.Assertions.*;

class LocationServiceTest {
    private static LocationService locationService =  LocationService.getService();
    private static Location location= LocationFactory.createLocation("10 Dorset street");

    @Test
    void create(){
        Location created = locationService.create(location);
        assertEquals(created.getStoreLocationId(), location.getStoreLocationId());
        System.out.println("Created ID: " + created.getStoreLocationId() + " Location: " + location.getStoreLocationId());

    }
    @Test
    void read() {
        Location read = locationService.read(location.getStoreLocationId());
        System.out.println("Location read: " + read);
    }
    @Test
    void update() {
        Location updated = new Location.Builder().copy(location).setStoreLocationId("2300").build();
        assertNotNull(locationService.update(updated));
        System.out.println("Updated ( " + updated.getStoreLocationId() + "): " + updated.getStoreLocationId()
                + " = Location: (" + location.getAddress() + "): " + location.getAddress());
    }
    @Test
    void delete() {
        boolean deleted = locationService.delete(location.getStoreLocationId());
        assertTrue(deleted);
        System.out.println("Deleted: " + location.getStoreLocationId());
    }

}