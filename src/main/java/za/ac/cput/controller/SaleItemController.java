//Faidh Adams 215060148
package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.SaleItem;
import za.ac.cput.factory.SaleItemFactory;
import za.ac.cput.service.impl.SaleItemService;
import java.util.Set;

@RestController
@RequestMapping("/saleitem")
public class SaleItemController {
    @Autowired
    private SaleItemService saleItemService;

    @GetMapping("")
    public Set<SaleItem> getAllSaleItems(){
        return saleItemService.getAll();
    }

    @GetMapping("/{id}")
    public SaleItem getSaleItem(@PathVariable String id){
        return saleItemService.read(id);
    }

    @PostMapping("")
    public SaleItem createSaleItem(@RequestBody SaleItem saleItem)
    {
        SaleItem newSaleItem = SaleItemFactory.createSaleItem(saleItem.getShoeId(), saleItem.getSaleId());
        return saleItemService.create(newSaleItem);
    }

    @PutMapping("/update")
    public SaleItem updateSaleItem(@RequestBody SaleItem saleItem){
        return saleItemService.update(saleItem);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSaleItem(@PathVariable String id){
        return saleItemService.delete(id);
    }
}
