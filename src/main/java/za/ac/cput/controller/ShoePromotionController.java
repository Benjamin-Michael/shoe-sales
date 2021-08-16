package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Promotion;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.factory.PromotionFactory;
import za.ac.cput.factory.ShoePromotionFactory;
import za.ac.cput.service.impl.ShoePromotionService;

import java.util.Set;

@RestController
@RequestMapping("/shoePromotion")
public class ShoePromotionController {
    @Autowired
    private ShoePromotionService shoePromotionService;

    @GetMapping("")
    public Set<ShoePromotion> getAllShoePromotions(){
        return shoePromotionService.getAll();
    }

    @PostMapping("")
    public ShoePromotion createShoePromotion(@RequestBody ShoePromotion shoePromotion){
        ShoePromotion newShoePromotion = ShoePromotionFactory.newShoePromotion(
                shoePromotion.getPromotionId(),
                shoePromotion.getShoeId(),
                shoePromotion.getStartDate(),
                shoePromotion.getEndDate());
        return shoePromotionService.create(newShoePromotion);
    }

    @GetMapping("/read/{id}")
    public ShoePromotion getShoePromotion(@PathVariable String id){
        return shoePromotionService.read(id);
    }

    @PostMapping("/update")
    public ShoePromotion updateShoePromotion(@RequestBody ShoePromotion shoePromotion){
        return shoePromotionService.update(shoePromotion);
    }

    @DeleteMapping("/{id}")
    public boolean deleteShoePromotion(@PathVariable String id){
        return shoePromotionService.delete(id);
    }

    @RequestMapping("/getall")
    public Set<ShoePromotion> getAll() {
        return shoePromotionService.getAll();
    }
}
