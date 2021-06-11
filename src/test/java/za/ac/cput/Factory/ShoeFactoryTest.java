/*  ShoeFactoryTest.java
    Test for ShoeFactory
    Author: Michael Benjamin (219071438)
    Date: 10 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Shoe;
import za.ac.cput.Util.GenericHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShoeFactoryTest {
    private Shoe shoe1, shoe2;

    @BeforeEach
    void setUp(){
        shoe1 = ShoeFactory.createShoe("Puma", GenericHelper.generateId());
        shoe2 = null;
    }

    @Test
    void testShoeCreation() {
        shoe2 = ShoeFactory.createShoe("Nike", GenericHelper.generateId());
        System.out.println(shoe2);

        assertNotNull(shoe2);
    }
    
    @Disabled
    @Test
    void testShoe1Creation(){
        shoe1 = ShoeFactory.createShoe("Puma", GenericHelper.generateId());
        System.out.println(shoe1);

        assertNotNull(shoe1);
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void testObject(){
        shoe2 = shoe1;
        System.out.println(shoe2);

        assertAll(
                () -> assertEquals(shoe1, shoe2),
                () -> assertSame(shoe1, shoe2)
        );

    }


}