/* PromotionRepositoryTest.java
   PromotionRepositoryTest using TDD
   @Author: Keenan Barends (219002959)
   @Date: 26 July 2021
*/

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Promotion;
import za.ac.cput.factory.PromotionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class PromotionRepositoryTest {

    private static PromotionRepository repository = PromotionRepository.getRepository();
    private static Promotion promotion = PromotionFactory.newPromotion("PM1","GET 50% OFF", 0.50);

    @Test
    void a_createPromotionTest()
    {
        // Arrange + Act
        Promotion newPromoRepo = repository.create(promotion);

        // Assert
        assertEquals(newPromoRepo.getPromotionId(), promotion.getPromotionId());

        // Tested-Object Output
        System.out.println("New Promotion Created:" + newPromoRepo);
    }

    @Test
    void b_readPromotionTest()
    {
        // Arrange + Act
        Promotion repoRead = repository.read(promotion.getPromotionId());

        // Assert
        assertNotNull(repoRead);

        // Tested-Object Output
        System.out.println("Promotion Read:" + repoRead);

    }

    @Test
    void c_updateExistingPromoTest()
    {
        // Arrange + Act
        Promotion updated = new Promotion.Builder().copy(promotion).setDiscountPercentage(0.25).build();

        // Assert
        assertNotNull(repository.update(updated));

        // Tested-Object Output
        System.out.println("Previous Promotion : " + promotion + " changed to -- >");
        System.out.println("Updated Promotion : " + updated);
    }

    @Test
    void d_deleteExistingPromoTest()
    {
        // Arrange + Act
        boolean success = repository.delete(promotion.getPromotionId());

        // Assert
        assertTrue(success);

        // Tested Object Output
        System.out.println("Promotion Deleted" + success);
    }

}