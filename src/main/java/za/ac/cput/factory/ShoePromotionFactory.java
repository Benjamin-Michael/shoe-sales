/*  ShoePromotionFactory.java
    Factory Class for ShoePromotion
    Author: Keenan Barends (219002959)
    Date: 10 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.util.GenericHelper;

public class ShoePromotionFactory {

    public static ShoePromotion newShoePromotion(String promotionId, String shoeId, String startDate, String endDate)
    {
        ShoePromotion shoePro = new ShoePromotion.Builder().setShoeId(shoeId).setPromotion(promotionId).setStartDate(startDate).setEndDate(endDate).build();

        return shoePro;
    }
}
