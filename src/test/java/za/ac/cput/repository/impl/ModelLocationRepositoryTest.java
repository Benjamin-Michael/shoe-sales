package za.ac.cput.repository.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ModelLocation;
import za.ac.cput.factory.ModelLocationFactory;

import static org.junit.jupiter.api.Assertions.*;

class ModelLocationRepositoryTest {
    private static ModelLocationRepository modelLocationRepository;
    private ModelLocation modelLocation;

    @BeforeEach
    void setUp(){
        modelLocationRepository = new ModelLocationRepository();
        modelLocation = ModelLocationFactory.createModelLocation("0005", "0006", "500");
    }
    @Test
    void create(){
        ModelLocation created = modelLocationRepository.create(modelLocation);
        assertEquals(created.getLocationId(), modelLocation.getLocationId());
        System.out.println("Created: " + created.getLocationId() + " = ModelId: " + modelLocation.getModelId());
    }
    @Test
    void read(){
        ModelLocation read = modelLocationRepository.read(modelLocation.getModelId());
        System.out.println("ModelId read: " + read);
    }
    @Test
    void update(){
        ModelLocation updated = new ModelLocation.Builder().copy(modelLocation).setModelId("0007").build();
        modelLocationRepository.update(updated);
        System.out.println("Updated ( " + updated.getLocationId() + "): " + updated.getLocationId()
                + " = ModelId: (" + modelLocation.getModelId() + "): " + modelLocation.getModelId());
    }
    @Test
    void delete(){
        modelLocationRepository.delete(modelLocation.getLocationId());
        System.out.println("Deleted: " + modelLocation.getLocationId());
    }

}
