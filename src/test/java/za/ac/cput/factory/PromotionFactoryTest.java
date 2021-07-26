/*  PromotionFactoryTest.java
    Test for PromotionFactory
    Author: Keenan Barends (219002959)
    Date: 10 June 2021
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Promotion;

import static org.junit.jupiter.api.Assertions.*;

class PromotionFactoryTest {

    private Promotion promo1, promo2, promo3, promo4;

    @BeforeEach
    public void setUp() {
        promo1 = PromotionFactory.newPromotion("PM1", "Get 50% off now on Vans Footwear.", 0.50);
        promo2 = PromotionFactory.newPromotion("PM1", "Get 25% off now on Nike Footwear.", 0.30);
        promo3 = promo1;
        promo4 = promo2;

    }

    // Object Equality
    @Test
    void testEquality()
    {
        promo2 = promo1;
        System.out.println(promo2);

        assertEquals(promo1, promo2);

    }

    // Object Identity
    @Test
    void testIdentity()
    {
        assertSame(promo1, promo3);
    }

    // Timeout Test
    @Timeout(1000)
    @Test
    void testTimeout()
    {
        assertEquals(promo2, promo4);
    }

    // Disabling Test
    @Disabled("This Test Won't Execute.")
    void testDisable()
    {
        assertEquals(promo1.toString(), promo2.toString());
        System.out.println("This Test won't execute");
    }


}