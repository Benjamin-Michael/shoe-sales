package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Model;
import za.ac.cput.factory.ModelFactory;

import static org.junit.jupiter.api.Assertions.*;

class ModelRepositoryTest {

    private static ModelRepository modelRepository;
    private Model model = ModelFactory.createModel( "Nike", "Nike Toshe", "Cr7 Runners");

    @Test
    void create() {
        Model created = modelRepository.create(model);
        assertEquals(created.getModelId(), model.getModelId());
        System.out.println("Created ID: " + created.getModelId() + " = Model: " + model.getModelId());
    }
    @Test
    void read() {
        Model read = modelRepository.read(model.getModelId());
        assertNotNull(read);
        System.out.println("Model Read: " + read + "\n");
    }
    @Test
    void update(){
        Model updated = new Model.Builder().copy(model).setModelName("Puma").build();
        assertNotNull(modelRepository.update(updated));
        System.out.println("Updated Model (" + updated.getModelId() + "): " + updated.getModelName()
                + "\n Old Model (" + model.getModelId() + "): " + model.getModelName() + "\n");
    }
    @Test
    void delete(){
        boolean deleted = modelRepository.delete(model.getModelId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);

    }
}

