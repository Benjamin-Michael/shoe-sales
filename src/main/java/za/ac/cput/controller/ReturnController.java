//Faidh Adams 215060148

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Return;
import za.ac.cput.factory.ReturnFactory;
import za.ac.cput.service.impl.ReturnService;

import java.util.Set;

@RestController
@RequestMapping("/return")
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    @GetMapping("")
    public Set<Return> getAllReturns(){
        return returnService.getAll();
    }

    @GetMapping("/{id}")
    public Return getReturn(@PathVariable String id){
        return returnService.read(id);
    }

    @PostMapping("")
    public Return createReturn(@RequestBody Return returns)
    {
        Return newReturn = ReturnFactory.createReturn(returns.getSaleId(), returns.getReturnDate());
        return returnService.create(newReturn);
    }

    @PutMapping("/update")
    public Return updateReturn(@RequestBody Return returns){
        return returnService.update(returns);
    }

    @DeleteMapping("/{id}")
    public boolean deleteReturn(@PathVariable String id){
        return returnService.delete(id);
    }
}
