package za.ac.cput.repository.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Model;
import za.ac.cput.factory.ModelFactory;

import static org.junit.jupiter.api.Assertions.*;

class ModelRepositoryTest {
    private static ModelRepository modelRepository;
    private Model model;

    @BeforeEach
    void setUp(){
        modelRepository = new ModelRepository();
        model = ModelFactory.createModel("All star white", "Old skull", "1995 designs");
    }
    @Test
    void create(){
        Model created = modelRepository.create(model);
        assertEquals(created.getModelId(), model.getModelId());
        System.out.println("Created: " + created.getModelId() + " = model: " + model.getModelName());
    }
    @Test
    void read(){
        Model read = modelRepository.read(model.getModelName());
        System.out.println("Model read: " + read);
    }
    @Test
    void update(){
        Model updated = new Model.Builder().copy(model).setModelId("00010").build();
        modelRepository.update(updated);
        System.out.println("Updated ( " + updated.getModelId() + "): " + updated.getModelId()
                + " = Model: (" + model.getModelName() + "): " + model.getModelName());
    }
    @Test
    void delete(){
        modelRepository.delete(model.getModelId());
        System.out.println("Deleted: " + model.getModelId());
    }
}

