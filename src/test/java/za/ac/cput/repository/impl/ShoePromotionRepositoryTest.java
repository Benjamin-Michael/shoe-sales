/* ShoePromotionRepositoryTest.java
   ShoePromotionRepositoryTest using TDD
   @Author: Keenan Barends (219002959)
   @Date: 26 July 2021
*/

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Promotion;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.factory.ShoePromotionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ShoePromotionRepositoryTest {

    private static ShoePromotionRepository repository = ShoePromotionRepository.getRepository();
    private static ShoePromotion shoePromotion1 = ShoePromotionFactory.newShoePromotion("PM001",
            "VANSSKU112", "01 JULY 2021", "25 JULY 2021");


    @Test
    void a_createShoePromotionTest()
    {
        // Arrange + Act
        ShoePromotion newShoePromoRepo = repository.create(shoePromotion1);

        // Assert
        assertEquals(newShoePromoRepo.getPromotionId(), shoePromotion1.getPromotionId());

        // Tested-Object Output
        System.out.println("New Promotion Created:" + newShoePromoRepo);
    }

    @Test
    void b_readShoePromotionTest()
    {
        // Arrange + Act
        ShoePromotion repoRead = repository.read(shoePromotion1.getPromotionId());

        // Assert
        assertNotNull(repoRead);

        // Tested-Object Output
        System.out.println("Shoe Promotion Read:" + repoRead);

    }

    @Test
    void c_updateExistingShoePromoTest()
    {
        // Arrange + Act
        ShoePromotion updated = new ShoePromotion.Builder().copy(shoePromotion1).setStartDate("10 July 2021").build();

        // Assert
        assertNotNull(repository.update(updated));

        // Tested-Object Output
        System.out.println("Previous Promotion : " + shoePromotion1 + " changed to -- >");
        System.out.println("Updated Promotion : " + updated);
    }

    @Test
    void d_deleteExistingShoePromoTest()
    {
        // Arrange + Act
        boolean success = repository.delete(shoePromotion1.getPromotionId());

        // Assert
        assertTrue(success);

        // Tested Object Output
        System.out.println("Promotion Deleted" + success);
    }
}
