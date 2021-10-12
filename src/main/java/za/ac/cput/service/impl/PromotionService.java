/* PromotionService.java
   PromotionService Implementation
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Promotion;
import za.ac.cput.repository.impl.PromotionRepository;

import java.util.Set;

@Service
public class PromotionService implements IPromotionService{

    private static PromotionService service = null;
    private PromotionRepository repository = null;

    private PromotionService()
    {
        this.repository = PromotionRepository.getRepository();
    }

    public static PromotionService getService(){
        if(service == null)
            service = new PromotionService();
        return service;
    }

    @Override
    public Promotion create(Promotion promotion) {
        return this.repository.create(promotion);
    }

    @Override
    public Promotion read(String promotionId) {
        return this.repository.read(promotionId);
    }

    @Override
    public Promotion update(Promotion promotion) {
        return this.repository.update(promotion);
    }

    @Override
    public boolean delete(String promotionId) {
        return this.repository.delete(promotionId);
    }

    @Override
    public Set<Promotion> getAll() {
        return this.repository.getAll();
    }
}
