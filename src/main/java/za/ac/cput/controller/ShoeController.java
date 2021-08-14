package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Shoe;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.service.impl.ShoeService;

import java.util.Set;

@RestController
@RequestMapping("/shoe")
public class ShoeController {

    @Autowired
    private ShoeService shoeService;


    @GetMapping("")
    public Set<Shoe> getAllShoes(){
        return shoeService.getAll();
    }

    @GetMapping("/{id}")
    public Shoe getShoe(@PathVariable String id){
        return shoeService.read(id);
    }

    @PostMapping("")
    public Shoe createShoe(@RequestBody Shoe shoe){
        Shoe newShoe = ShoeFactory.createShoe(shoe.getBrand(), shoe.getModelId(), shoe.getShoeTypeId(), shoe.getShoeSizeId());
        return shoeService.create(newShoe);
    }

    @PostMapping("/update")
    public Shoe updateShoe(@RequestBody Shoe shoe){
        return shoeService.update(shoe);
    }

    @DeleteMapping("/{id}")
    public boolean deleteShoe(@PathVariable String id){
        return shoeService.delete(id);
    }

}
