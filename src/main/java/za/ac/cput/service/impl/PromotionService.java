/* PromotionService.java
   PromotionService Implementation
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Promotion;
import za.ac.cput.repository.PromotionRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromotionService implements IPromotionService{

    private static PromotionService promotionService = null;

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public Promotion create(Promotion promotion) {
        return this.promotionRepository.save(promotion);
    }

    @Override
    public Promotion read(String promotionId) {
        return this.promotionRepository.findById(promotionId).orElse(null);
    }

    @Override
    public Promotion update(Promotion promotion) {
        if(this.promotionRepository.existsById(promotion.getPromotionId()))
            return this.promotionRepository.save(promotion);
        return null;
    }

    @Override
    public boolean delete(String promotionId) {
        this.promotionRepository.deleteById(promotionId);

        if(this.promotionRepository.existsById(promotionId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Promotion> getAll() {
        return this.promotionRepository.findAll().stream().collect(Collectors.toSet());
    }
}
