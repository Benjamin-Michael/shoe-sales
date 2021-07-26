package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ShoeSize;
import za.ac.cput.factory.ShoeSizeFactory;

import static org.junit.jupiter.api.Assertions.*;

class ShoeSizeRepositoryTest {

    private static ShoeSizeRepository shoeSizeRepository;
    private ShoeSize shoeSize;

    @BeforeEach
    void setUp() {
        shoeSizeRepository = new ShoeSizeRepository();
        shoeSize = ShoeSizeFactory.createShoeSize(7, true);
    }

    @Test
    void create() {
        ShoeSize created = shoeSizeRepository.create(shoeSize);
        assertEquals(created.getShoeSizeId(), shoeSize.getShoeSizeId());
        System.out.println("Created: " + created.getShoeSizeId() + " = ShoeSize: " + shoeSize.getShoeSizeId());
    }

    @Test
    void read() {
        ShoeSize read = shoeSizeRepository.read(shoeSize.getShoeSizeId());
        System.out.println("ShoeSize Read: " + read);
    }

    @Test
    void update() {
        ShoeSize updated = new ShoeSize.Builder().copy(shoeSize).setSize(6).build();
        shoeSizeRepository.update(updated);
        System.out.println("Updated (" + updated.getShoeSizeId() + "): " + updated.getSize()
                + " = ShoeSize: (" + shoeSize.getShoeSizeId() + "): " + shoeSize.getSize());
    }

    @Test
    void delete() {
        shoeSizeRepository.delete(shoeSize.getShoeSizeId());
        System.out.println("Deleted: " + shoeSize.getShoeSizeId());
    }

    @Test
    void getAll() {
    }

}