package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ShoeType;
import za.ac.cput.factory.ShoeTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShoeTypeServiceTest {

    private static ShoeTypeService shoeTypeService = ShoeTypeService.getService();
    private static ShoeType shoeType = ShoeTypeFactory.createShoeType("Navy Blue", 1500);

    @Test
    void a_create() {
        ShoeType created = shoeTypeService.create(shoeType);
        assertEquals(created.getShoeTypeId(), shoeType.getShoeTypeId());
        System.out.println("Created ID: " + created.getShoeTypeId() + "\nShoeType ID: " + shoeType.getShoeTypeId() + "\n");
    }

    @Test
    void b_read() {
        ShoeType read = shoeTypeService.read(shoeType.getShoeTypeId());
        assertNotNull(read);
        System.out.println("ShoeType Read: " + read + "\n");
    }

    @Test
    void c_update() {
        ShoeType updated = new ShoeType.Builder().copy(shoeType).setPrice(1250).build();
        assertNotNull(shoeTypeService.update(updated));
        System.out.println("Updated ShoeType (" + updated.getShoeTypeId() + "): " + updated.getPrice()
                + "\nOld ShoeType (" + shoeType.getShoeTypeId() + "): " + shoeType.getPrice() + "\n");

    }

    @Test
    void e_delete() {
        boolean deleted = shoeTypeService.delete(shoeType.getShoeTypeId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll() {
        System.out.println(shoeTypeService.getAll() + "\n");
    }
}