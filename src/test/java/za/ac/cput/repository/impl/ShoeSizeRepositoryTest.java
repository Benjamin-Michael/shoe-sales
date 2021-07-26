package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.ShoeSize;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.factory.ShoeSizeFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShoeSizeRepositoryTest {

    private static ShoeSizeRepository shoeSizeRepository = ShoeSizeRepository.getRepository();
    private static ShoeSize shoeSize = ShoeSizeFactory.createShoeSize(7, true);

    @Test
    void a_create() {
        ShoeSize created = shoeSizeRepository.create(shoeSize);
        assertEquals(created.getShoeSizeId(), shoeSize.getShoeSizeId());
        System.out.println("Created: " + created.getShoeSizeId() + "\nShoeSize: " + shoeSize.getShoeSizeId() + "\n");
    }

    @Test
    void b_read() {
        //a_create();
        ShoeSize read = shoeSizeRepository.read(shoeSize.getShoeSizeId());
        assertNotNull(read);
        System.out.println("ShoeSize Read: " + read + "\n");
    }

    @Test
    void c_update() {
        ShoeSize updated = new ShoeSize.Builder().copy(shoeSize).setSize(8).build();
        assertNotNull(shoeSizeRepository.update(updated));
        System.out.println("Updated (" + updated.getShoeSizeId() + "): " + updated.getSize()
                + " = ShoeSize: (" + shoeSize.getShoeSizeId() + "): " + shoeSize.getSize() + "\n");
    }

    @Test
    void e_delete() {
        boolean deleted = shoeSizeRepository.delete(shoeSize.getShoeSizeId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll() {
        System.out.println(shoeSizeRepository.getAll() + "\n");
    }

}