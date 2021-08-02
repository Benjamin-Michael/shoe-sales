/* ShoePromotionRepository.java
   ShoePromotionRepository Implementation
   @Author: Keenan Barends (219002959)
   @Date: 26 July 2021
*/

package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoePromotion;

import java.util.HashSet;
import java.util.Set;

public class ShoePromotionRepository implements IShoePromotionRepository{

    private static ShoePromotionRepository repository = null;
    private Set<ShoePromotion> shoePromoDb = null;

    private ShoePromotionRepository()
    {
        shoePromoDb = new HashSet<ShoePromotion>();
    }

    public static ShoePromotionRepository getRepository()
    {
        if (repository == null)
        {
            repository = new ShoePromotionRepository();
        }
        return repository;
    }

    // ---- Create
    @Override
    public ShoePromotion create(ShoePromotion shoePromotion) {
        boolean success = shoePromoDb.add(shoePromotion);
        if(!success)
            return null;
        return shoePromotion;
    }

    // ---- Read
    @Override
    public ShoePromotion read(String shoePromotionId) {
        for (ShoePromotion sP : shoePromoDb)
            if (sP.getPromotionId().equals(shoePromotionId))
            {
                return sP;
            }
        return null;
    }

    // ---- Update
    @Override
    public ShoePromotion update(ShoePromotion shoePromotion) {
        ShoePromotion existShoePromo = read(shoePromotion.getPromotionId());
        if (existShoePromo != null)
        {
            shoePromoDb.remove(existShoePromo);
            shoePromoDb.add(shoePromotion);
            return shoePromotion;
        }
        return null;
    }

    // ---- Delete
    @Override
    public boolean delete(String shoePromotionId) {
        ShoePromotion shoePromotion = read(shoePromotionId);

        if(shoePromotion == null)
            return false;
        shoePromoDb.remove(shoePromotionId);
        return true;
    }

    @Override
    public Set<ShoePromotion> getAll() {
        return null;
    }
}
