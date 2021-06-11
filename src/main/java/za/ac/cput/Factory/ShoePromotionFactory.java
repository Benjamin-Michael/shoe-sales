/*  ShoePromotionFactory.java
    Factory Class for ShoePromotion
    Author: Keenan Barends (219002959)
    Date: 10 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.ShoePromotion;
import za.ac.cput.Util.GenericHelper;

public class ShoePromotionFactory {

    public static ShoePromotion newShoePromotion(String shoeId, String startDate, String endDate)
    {
        //PromotionFactory proFac = new PromotionFactory();

        // Generating an Unique ID

        String promotionId = GenericHelper.generateId();

        ShoePromotion shoePro = new ShoePromotion.Builder().setShoeId(shoeId).setPromotion(promotionId).setStartDate(startDate).setEndDate(endDate).build();

        return shoePro;
    }
}
