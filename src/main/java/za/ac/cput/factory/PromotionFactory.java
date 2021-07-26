/*  PromotionFactory.java
    Factory Class for Promotion
    Author: Keenan Barends (219002959)
    Date: 10 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Promotion;
import za.ac.cput.util.GenericHelper;

public class PromotionFactory {

    public static Promotion newPromotion(String promotionId, String description, Double percentage)
    {

        Promotion promotion = new Promotion.Builder().setPromotionId(promotionId).setDescription(description).setDiscountPercentage(percentage).build();

        return promotion;
    }
}


