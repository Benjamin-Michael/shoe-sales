package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Model;

import za.ac.cput.factory.ModelFactory;

import static org.junit.jupiter.api.Assertions.*;

class ModelServiceTest {
    private static ModelService modelService =  ModelService.getService();
    private static Model model= ModelFactory.createModel("Vans", " Sneaker"," BLK&WHT");

    @Test
    void create(){
        Model created = modelService.create(model);
        assertEquals(created.getModelId(), model.getModelId());
        System.out.println("Created ID: " + created.getModelId() + " Model: " + model.getModelName());

    }
    @Test
    void read() {
        Model read = modelService.read(model.getModelId());
        System.out.println("Model being read: " + read);
    }
    @Test
    void update() {
        Model updated = new Model.Builder().copy(model).setModelId("011").build();
        assertNotNull(modelService.update(updated));
        System.out.println("Updated ( " + updated.getModelId() + "): " + updated.getModelId()
                + " = Model: (" + model.getModelName() + "): " + model.getModelName());
    }
    @Test
    void delete() {
        boolean deleted = modelService.delete(model.getModelId());
        assertTrue(deleted);
        System.out.println("Deleted: " + model.getModelId());
    }
}