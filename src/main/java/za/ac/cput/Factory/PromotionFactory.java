/*  PromotionFactory.java
    Factory Class for Promotion
    Author: Keenan Barends (219002959)
    Date: 10 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Promotion;
import za.ac.cput.Util.GenericHelper;

import java.text.DecimalFormat;

public class PromotionFactory {

    public static Promotion newPromotion(String description, String percentage)
    {

        String promotionId = GenericHelper.generateId();

        Promotion promotion = new Promotion.Builder().setPromotionId(promotionId).setDescription(description).setDiscountPercentage(percentage).build();

        return promotion;
    }
}


