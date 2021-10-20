package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ModelLocation;
import za.ac.cput.factory.ModelLocationFactory;

import static org.junit.jupiter.api.Assertions.*;

class ModelLocationServiceTest {
    private static ModelLocationService modelLocationService =  ModelLocationService.getService();
    private static ModelLocation modelLocation= ModelLocationFactory.createModelLocation("01s", "Nike","400");

    @Test
    void create(){
        ModelLocation created = modelLocationService.create(modelLocation);
        assertEquals(created.getLocationId(), modelLocation.getLocationId());
        System.out.println("Created ID: " + created.getLocationId() + " Model Location: " + modelLocation.getLocationId());

    }
    @Test
    void read() {
        ModelLocation read = modelLocationService.read(modelLocation.getLocationId());
        System.out.println("Model Location being  read: " + read);
    }
    @Test
    void update() {
        ModelLocation updated = new ModelLocation.Builder().copy(modelLocation).setLocationId("Bellville 045").build();
        assertNotNull(modelLocationService.update(updated));
        System.out.println("Updated ( " + updated.getLocationId() + "): " + updated.getLocationId()
                + " = Location: (" + modelLocation.getLocationId() + "): " + modelLocation.getLocationId());
    }
    @Test
    void delete() {
        boolean deleted = modelLocationService.delete(modelLocation.getLocationId());
        assertTrue(deleted);
        System.out.println("Deleted: " + modelLocation.getLocationId());
    }
}