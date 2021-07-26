package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ShoeType;
import za.ac.cput.factory.ShoeTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShoeTypeRepositoryTest {

    private static ShoeTypeRepository shoeTypeRepository = ShoeTypeRepository.getRepository();
    private static ShoeType shoeType = ShoeTypeFactory.createShoeType("Black", 850.00);

    @Test
    void a_create() {
        ShoeType created = shoeTypeRepository.create(shoeType);
        assertEquals(created.getShoeTypeId(), shoeType.getShoeTypeId());
        System.out.println("Created: " + created.getShoeTypeId() + "\nShoeType: " + shoeType.getShoeTypeId() + "\n");
    }

    @Test
    void b_read() {
        ShoeType read = shoeTypeRepository.read(shoeType.getShoeTypeId());
        assertNotNull(read);
        System.out.println("ShoeType Read: " + read + "\n");
    }

    @Test
    void c_update() {
        ShoeType updated = new ShoeType.Builder().copy(shoeType).setColour("White").build();
        assertNotNull(shoeTypeRepository.update(updated));
        System.out.println("Updated (" + updated.getShoeTypeId() + "): " + updated.getColour()
                + " = ShoeType: (" + shoeType.getShoeTypeId() + "): " + shoeType.getColour() + "\n");
    }

    @Test
    void delete() {
        boolean deleted = shoeTypeRepository.delete(shoeType.getShoeTypeId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll() {
        System.out.println(shoeTypeRepository.getAll() + "\n");
    }
}