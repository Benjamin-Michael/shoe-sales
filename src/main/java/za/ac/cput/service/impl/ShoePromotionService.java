/* ShoePromotionService.java
   ShoePromotionService Implementation
   @Author: Keenan Barends (219002959)
   @Date: 02 August 2021
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.repository.ShoePromotionRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoePromotionService implements IShoePromotionService{

    private static ShoePromotionService service = null;

    @Autowired
    private ShoePromotionRepository shoePromotionRepository;

    @Override
    public ShoePromotion create(ShoePromotion shoePromotion) {
        return this.shoePromotionRepository.save(shoePromotion);
    }

    @Override
    public ShoePromotion read(String shoePromotionId) {
        return this.shoePromotionRepository.findById(shoePromotionId).orElse(null);
    }

    @Override
    public ShoePromotion update(ShoePromotion shoePromotion) {
        if(this.shoePromotionRepository.existsById(shoePromotion.getPromotionId()))
            return this.shoePromotionRepository.save(shoePromotion);
        return null;
    }

    @Override
    public boolean delete(String shoePromotionId) {
        this.shoePromotionRepository.deleteById(shoePromotionId);

        if(this.shoePromotionRepository.existsById(shoePromotionId))
            return false;
        else
            return true;
    }

    @Override
    public Set<ShoePromotion> getAll() {
        return this.shoePromotionRepository.findAll().stream().collect(Collectors.toSet());
    }
}
