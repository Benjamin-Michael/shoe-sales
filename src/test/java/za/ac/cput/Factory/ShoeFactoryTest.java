/*  ShoeFactoryTest.java
    Test for ShoeFactory
    Author: Michael Benjamin (219071438)
    Date: 10 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Shoe;
import za.ac.cput.Util.GenericHelper;

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

    @Test
    void testObject(){
        shoe2 = shoe1;
        System.out.println(shoe2);

        assertAll(
                () -> assertEquals(shoe1, shoe2),
                () -> assertSame(shoe1, shoe2)
        );

    }


}