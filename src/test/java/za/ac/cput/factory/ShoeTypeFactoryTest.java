/*  ShoeTypeFactoryTest.java
    Test for ShoeTypeFactory
    Author: Michael Benjamin (219071438)
    Date: 11 June 2021
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.ShoeType;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTypeFactoryTest {

    private ShoeType shoeType1, shoeType2;

    @BeforeEach
    void setUp() {
        shoeType1 = ShoeTypeFactory.createShoeType("Black", 1999.99);
        shoeType2 = null;
    }

    @Test
    void testShoeTypeCreation() {
        shoeType2 = ShoeTypeFactory.createShoeType("White", 1599.99);
        System.out.println(shoeType2);

        assertNotNull(shoeType2);
    }

    @Disabled
    @Test
    void testShoeType1Creation(){
        shoeType1 = ShoeTypeFactory.createShoeType("Blue", 1499.99);
        System.out.println(shoeType1);

        assertNotNull(shoeType1);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testObject(){
        shoeType2 = shoeType1;
        System.out.println(shoeType2);

        assertAll(
                () -> assertEquals(shoeType1, shoeType2),
                () -> assertSame(shoeType1, shoeType2)
        );

    }

}