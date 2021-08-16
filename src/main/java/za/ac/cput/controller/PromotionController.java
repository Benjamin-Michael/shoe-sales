package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Promotion;
import za.ac.cput.factory.PromotionFactory;
import za.ac.cput.service.impl.PromotionService;

import java.util.Set;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("")
    public Set<Promotion> getAllPromotions(){
        return promotionService.getAll();
    }

    @GetMapping("/{id}")
    public Promotion getPromotion(@PathVariable String id){
        return promotionService.read(id);
    }

    @PostMapping("")
    public Promotion createPromotion(@RequestBody Promotion promotion){
        Promotion newPromotion = PromotionFactory.newPromotion(promotion.getPromotionId(), promotion.getDescription(), promotion.getDiscountPercentage());
        return promotionService.create(newPromotion);
    }

    @PostMapping("/update")
    public Promotion updatePromotion(@RequestBody Promotion promotion){
        return promotionService.update(promotion);
    }

    @DeleteMapping("/{id}")
    public boolean deletePromotion(@PathVariable String id){
        return promotionService.delete(id);
    }

}
