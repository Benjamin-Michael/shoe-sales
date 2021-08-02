/* IPromotionService.java
   IPromotionService Implementation
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import za.ac.cput.entity.Promotion;
import za.ac.cput.service.IService;
import java.util.Set;

public interface IPromotionService extends IService<Promotion, String> {
    Set<Promotion> getAll();
}
