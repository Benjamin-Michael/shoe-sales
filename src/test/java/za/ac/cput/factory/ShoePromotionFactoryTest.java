/*  ShoePromotionFactoryTest.java
    Test for ShoePromotionFactory
    Author: Keenan Barends (219002959)
    Date: 10 June 2021
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.ShoePromotion;

import static org.junit.jupiter.api.Assertions.*;

class ShoePromotionFactoryTest {

    private ShoePromotion shoePromo1, shoePromo2, shoePromo3, shoePromo4;

    @BeforeEach
    void setUp()
    {
        shoePromo1 = ShoePromotionFactory.newShoePromotion("0001", "135VNS","01 June 2021", "31 June 2021" );
        shoePromo2 = ShoePromotionFactory.newShoePromotion("0002", "246NKS","01 June 2021", "30 June 2021" );
        shoePromo3 = shoePromo1;
        shoePromo4 = shoePromo2;
    }

    // Object Equality
    @Test
    void testEquality()
    {
        shoePromo2 = shoePromo1;
        System.out.println(shoePromo2);

        assertEquals(shoePromo1, shoePromo2);

    }

    // Object Identity
    @Test
    void testIdentity()
    {
        assertSame(shoePromo1, shoePromo3);
    }

    // Timeout Test
    @Timeout(1000)
    @Test
    void testTimeout()
    {
        assertEquals(shoePromo2, shoePromo4);
    }

    // Disabling Test
    @Disabled("This Test Won't Execute.")
    void testDisable()
    {
        assertEquals(shoePromo1.toString(), shoePromo2.toString());

    }

}