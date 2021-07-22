package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Shoe;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

class ShoeRepositoryTest {

    private static ShoeRepository shoeRepository;
    private Shoe shoe;

    @BeforeEach
    void setUp() {
        shoeRepository = new ShoeRepository();
        shoe = ShoeFactory.createShoe("Adidas", GenericHelper.generateId()
                , GenericHelper.generateId()
                , GenericHelper.generateId());
    }

    @Test
    void create() {
        Shoe created = shoeRepository.create(shoe);
        assertEquals(created.getShoeId(), shoe.getShoeId());
        System.out.println("Created: " + created.getShoeId() + " = Shoe: " + shoe.getShoeId());
    }

    @Test
    void read() {
        Shoe read = shoeRepository.read(shoe.getShoeId());
        System.out.println("Shoe Read: " + read);
    }

    @Test
    void update() {
        Shoe updated = new Shoe.Builder().copy(shoe).setBrand("Nike").build();
        shoeRepository.update(updated);
        System.out.println("Updated (" + updated.getShoeId() + "): " + updated.getBrand()
                + " = Shoe: (" + shoe.getShoeId() + "): " + shoe.getBrand());
    }

    @Test
    void delete() {
        shoeRepository.delete(shoe.getShoeId());
        System.out.println("Deleted: " + shoe.getShoeId());
    }
}