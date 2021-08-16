/* ShoePromotionService.java
   ShoePromotionService Implementation
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.repository.impl.ShoePromotionRepository;

import java.util.Set;

@Service
public class ShoePromotionService implements IShoePromotionService{

    private static ShoePromotionService service = null;
    private ShoePromotionRepository repository = null;

    public ShoePromotionService() { this.repository = ShoePromotionRepository.getRepository(); }

    public static ShoePromotionService getService(){
        if(service == null)
            service = new ShoePromotionService();
        return service;
    }

    @Override
    public ShoePromotion create(ShoePromotion shoePromotion) {
        return this.repository.create(shoePromotion);
    }

    @Override
    public ShoePromotion read(String shoePromotionId) {
        return this.repository.read(shoePromotionId);
    }

    @Override
    public ShoePromotion update(ShoePromotion shoePromotion) {
        return this.repository.update(shoePromotion);
    }

    @Override
    public boolean delete(String shoePromotionId) {
        return this.repository.delete(shoePromotionId);
    }

    @Override
    public Set<ShoePromotion> getAll() {
        return this.repository.getAll();
    }
}
