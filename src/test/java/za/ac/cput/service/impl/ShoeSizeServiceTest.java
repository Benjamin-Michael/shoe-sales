package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ShoeSize;
import za.ac.cput.factory.ShoeSizeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShoeSizeServiceTest {

    private static ShoeSizeService shoeSizeService = ShoeSizeService.getService();
    private static ShoeSize shoeSize = ShoeSizeFactory.createShoeSize(11, false);

    @Test
    void a_create() {
        ShoeSize created = shoeSizeService.create(shoeSize);
        assertEquals(created.getShoeSizeId(), shoeSize.getShoeSizeId());
        System.out.println("Created ID: " + created.getShoeSizeId() + "\nShoeSize ID: " + shoeSize.getShoeSizeId() + "\n");
    }

    @Test
    void b_read() {
        ShoeSize read = shoeSizeService.read(shoeSize.getShoeSizeId());
        assertNotNull(read);
        System.out.println("ShoeSize Read: " + read + "\n");
    }

    @Test
    void c_update() {
        ShoeSize updated = new ShoeSize.Builder().copy(shoeSize).isAdultSize(true).build();
        assertNotNull(shoeSizeService.update(updated));
        System.out.println("Updated ShoeSize (" + updated.getShoeSizeId() + "): " + updated.isAdultSize()
                + "\nOld ShoeSize (" + shoeSize.getShoeSizeId() + "): " + shoeSize.isAdultSize() + "\n");
    }

    @Test
    void e_delete() {
        boolean deleted = shoeSizeService.delete(shoeSize.getShoeSizeId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll() {
        System.out.println(shoeSizeService.getAll() + "\n");
    }
}