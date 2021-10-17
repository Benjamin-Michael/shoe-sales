/* IPromotionRepository.java
   IPromotionRepository Implementation
   @Author: Keenan Barends (219002959)
   @Date: 26 July 2021
*/

package za.ac.cput.repository.impl;

import za.ac.cput.entity.Promotion;
import za.ac.cput.repository.IRepository;

import java.util.Set;

@Deprecated
public interface IPromotionRepository extends IRepository<Promotion, String>
{
    public Set<Promotion> getAll();
}
