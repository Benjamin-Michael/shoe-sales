package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Shoe;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.repository.impl.ShoeRepository;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShoeServiceTest {

    private static ShoeService shoeService;     //= ShoeService.getService();
    private static Shoe shoe = ShoeFactory.createShoe("Nike", GenericHelper.generateId(), GenericHelper.generateId(), GenericHelper.generateId());

    @Test
    void a_create() {
        Shoe created = shoeService.create(shoe);
        assertEquals(created.getShoeId(), shoe.getShoeId());
        System.out.println("Created ID: " + created.getShoeId() + "\nShoe ID: " + shoe.getShoeId() + "\n");
    }

    @Test
    void b_read() {
        Shoe read = shoeService.read(shoe.getShoeId());
        assertNotNull(read);
        System.out.println("Shoe Read: " + read + "\n");
    }

    @Test
    void c_update() {
        Shoe updated = new Shoe.Builder().copy(shoe).setBrand("Puma").build();
        assertNotNull(shoeService.update(updated));
        System.out.println("Updated Shoe (" + updated.getShoeId() + "): " + updated.getBrand()
                + "\nOld Shoe (" + shoe.getShoeId() + "): " + shoe.getBrand() + "\n");
    }

    @Test
    void e_delete() {
        boolean deleted = shoeService.delete(shoe.getShoeId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll() {
        System.out.println(shoeService.getAll() + "\n");
    }


}