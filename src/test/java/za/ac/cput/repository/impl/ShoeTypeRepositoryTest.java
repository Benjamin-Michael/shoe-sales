package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ShoeType;
import za.ac.cput.factory.ShoeTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTypeRepositoryTest {

    private static ShoeTypeRepository shoeTypeRepository;
    private ShoeType shoeType;


    @BeforeEach
    void setUp() {
        shoeTypeRepository = new ShoeTypeRepository();
        shoeType = ShoeTypeFactory.createShoeType("Black", 750.00);
    }

    @Test
    void create() {
        ShoeType created = shoeTypeRepository.create(shoeType);
        assertEquals(created.getShoeTypeId(), shoeType.getShoeTypeId());
        System.out.println("Created: " + created.getShoeTypeId() + " = ShoeType: " + shoeType.getShoeTypeId());
    }

    @Test
    void read() {
        ShoeType read = shoeTypeRepository.read(shoeType.getShoeTypeId());
        System.out.println("ShoeType Read: " + read);
    }

    @Test
    void update() {
        ShoeType updated = new ShoeType.Builder().copy(shoeType).setColour("White").build();
        shoeTypeRepository.update(updated);
        System.out.println("Updated (" + updated.getShoeTypeId() + "): " + updated.getColour()
                + " = ShoeType: (" + shoeType.getShoeTypeId() + "): " + shoeType.getColour());
    }

    @Test
    void delete() {
        shoeTypeRepository.delete(shoeType.getShoeTypeId());
        System.out.println("Deleted: " + shoeType.getShoeTypeId());
    }

    @Test
    void getAll() {
    }
}