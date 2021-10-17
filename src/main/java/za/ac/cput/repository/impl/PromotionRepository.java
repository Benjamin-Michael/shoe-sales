/* PromotionRepository.java
   PromotionRepository Implementation
   @Author: Keenan Barends (219002959)
   @Date: 26 July 2021
*/

package za.ac.cput.repository.impl;

import za.ac.cput.entity.Promotion;

import java.util.HashSet;
import java.util.Set;

@Deprecated
public class PromotionRepository implements IPromotionRepository {

    private static PromotionRepository repository = null;
    private Set<Promotion> promoDb = null;

    private PromotionRepository()
    {
        promoDb = new HashSet<Promotion>();
    }

    public static PromotionRepository getRepository()
    {
        if (repository == null)
        {
            repository = new PromotionRepository();
        }
        return repository;
    }

    // ---- Create
    @Override
    public Promotion create(Promotion promotion) {
        boolean success = promoDb.add(promotion);
        if(!success)
            return null;
        return promotion;
    }

    // ---- Read
    @Override
    public Promotion read(String promotionId)
    {
        for (Promotion p : promoDb)
            if (p.getPromotionId().equals(promotionId))
            {
                return p;
            }
        return null;
    }

    // ---- Update
    @Override
    public Promotion update(Promotion promotion)
    {
        Promotion existPromo = read(promotion.getPromotionId());
        if (existPromo != null)
        {
            promoDb.remove(existPromo);
            promoDb.add(promotion);
            return promotion;
        }
        return null;
    }

    // ---- Delete
    @Override
    public boolean delete(String promotionId) {
        Promotion promotion = read(promotionId);

        if(promotion == null)
            return false;
        promoDb.remove(promotionId);
        return true;
    }

    @Override
    public Set<Promotion> getAll(){
        return promoDb;
    }
}