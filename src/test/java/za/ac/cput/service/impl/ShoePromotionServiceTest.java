/* ShoePromotionServiceTest.java
   ShoePromotionServiceTest Class using TDD
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Promotion;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.factory.ShoePromotionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShoePromotionServiceTest {

    private static ShoePromotionService service = ShoePromotionService.getService();
    private static ShoePromotion shoePromotion = ShoePromotionFactory.newShoePromotion("PM001", "VNS234", "01 JULY 2021", "31 JULY 2021");

    @Test
    void a_create()
    {
        ShoePromotion newPromo = service.create(shoePromotion);
        assertEquals(newPromo.getPromotionId(), shoePromotion.getPromotionId());
        System.out.println("Created New Shoe Promotion : " + newPromo.toString());
    }

    @Test
    void b_read()
    {
        ShoePromotion readShoePromo = service.read(shoePromotion.getPromotionId());
        assertNotNull(readShoePromo);
        System.out.println("\nPromotion : " + readShoePromo.toString());
    }

    @Test
    void c_update()
    {
        ShoePromotion updateShoePromo = new ShoePromotion.Builder().copy(shoePromotion).setStartDate("15 July 2021").build();
        assertNotNull(service.update(updateShoePromo));
        System.out.println("\nUpdated : " + updateShoePromo.toString());
    }

    @Test
    void d_delete()
    {
        boolean success = service.delete(shoePromotion.getPromotionId());
        assertTrue(success);
        System.out.println("Delete:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("All Shoe Promotions : ");
        System.out.println(service.getAll());
        System.out.println(" ");
    }
}