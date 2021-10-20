//Faidh Adams 215060148
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Sale;
import za.ac.cput.factory.SaleFactory;
import za.ac.cput.service.impl.SaleService;
import java.util.Set;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/getall")
    public Set<Sale> getAllSales(){
        return saleService.getAll();
    }

    @GetMapping("/{id}")
    public Sale getSale(@PathVariable String id){
        return saleService.read(id);
    }

    @PostMapping("/create")
    public Sale createSale(@RequestBody Sale sale)
    {
        Sale newSale = SaleFactory.createSale(sale.getStaffId(), sale.getSaleTotal(), sale.getSaleDate());
        return saleService.create(newSale);
    }

    @PutMapping("/update")
    public Sale updateSale(@RequestBody Sale sale){
        return saleService.update(sale);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSale(@PathVariable String id){
        return saleService.delete(id);
    }
}
