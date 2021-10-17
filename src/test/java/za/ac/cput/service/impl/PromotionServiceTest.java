/* PromotionServiceTest.java
   PromotionServiceTest Class using TDD
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Promotion;
import za.ac.cput.factory.PromotionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class PromotionServiceTest {

    private static PromotionService service ; //=  PromotionService.getService();
    private static Promotion promotion = PromotionFactory.newPromotion("PM001", "50% OF VANS NOW!", 50.00);

    @Test
    void a_create()
    {
        Promotion newPromo = service.create(promotion);
        assertEquals(newPromo.getPromotionId(), promotion.getPromotionId());
        System.out.println("Created New Promotion : " + newPromo.toString());
    }

    @Test
    void b_read()
    {
        Promotion readPromo = service.read(promotion.getPromotionId());
        assertNotNull(readPromo);
        System.out.println("\nPromotion : " + readPromo.toString());
    }

    @Test
    void c_update()
    {
        Promotion updatePromo = new Promotion.Builder().copy(promotion).setDiscountPercentage(40.00).build();
        assertNotNull(service.update(updatePromo));
        System.out.println("\nUpdated : " + updatePromo.toString());
    }

    @Test
    void d_delete()
    {
        boolean success = service.delete(promotion.getPromotionId());
        assertTrue(success);
        System.out.println("Delete : " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("All Promotions : ");
        System.out.println(service.getAll());
        System.out.println(" ");
    }
}