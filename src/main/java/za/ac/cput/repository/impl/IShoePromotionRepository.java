/* IShoePromotionRepository.java
   IShoePromotionRepository Implementation
   @Author: Keenan Barends (219002959)
   @Date: 26 July 2021
*/

package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IShoePromotionRepository extends IRepository<ShoePromotion, String> {
    public Set<ShoePromotion> getAll();
}
