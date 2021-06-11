package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.ShoeSize;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShoeSizeFactoryTest {

    private ShoeSize shoeSize1, shoeSize2;

    @BeforeEach
    void setUp() {
        shoeSize1 = ShoeSizeFactory.createShoeSize(7, true);
        shoeSize2 = null;
    }

    @Test
    void testShoeTypeCreation() {
        shoeSize2 = ShoeSizeFactory.createShoeSize(6, true);
        System.out.println(shoeSize2);

        assertNotNull(shoeSize2);
    }

    @Disabled
    @Test
    void testShoeSize1Creation(){
        shoeSize1 = ShoeSizeFactory.createShoeSize(4, false);
        System.out.println(shoeSize1);

        assertNotNull(shoeSize1);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testObject(){
        shoeSize2 = shoeSize1;
        System.out.println(shoeSize2);

        assertAll(
                () -> assertEquals(shoeSize1, shoeSize2),
                () -> assertSame(shoeSize1, shoeSize2)
        );

    }

}