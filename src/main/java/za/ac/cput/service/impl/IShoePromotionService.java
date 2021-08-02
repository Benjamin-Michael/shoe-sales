/* IShoePromotionService.java
   IShoePromotionService Implementation
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import za.ac.cput.entity.Promotion;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IShoePromotionService extends IService<ShoePromotion, String> {

    Set<ShoePromotion> getAll();
}
