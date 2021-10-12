//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.SaleItem;
import za.ac.cput.repository.impl.SaleItemRepository;

import java.util.Set;

@Service
public class SaleItemService implements ISaleItemService{

    private static SaleItemService saleItemService = null;
    private SaleItemRepository saleItemRepository = null;

    private SaleItemService(){
        this.saleItemRepository = SaleItemRepository.getRepository();
    }

    public static SaleItemService getService(){
        if(saleItemService == null)
            saleItemService = new SaleItemService();
        return saleItemService;
    }

    @Override
    public SaleItem create(SaleItem saleItem){
        return this.saleItemRepository.create(saleItem);
    }

    @Override
    public SaleItem read(String saleItemId) {
        return this.saleItemRepository.read(saleItemId);
    }

    @Override
    public SaleItem update(SaleItem saleItem) {
        return this.saleItemRepository.update(saleItem);
    }

    @Override
    public boolean delete(String saleItemId) {
        return this.saleItemRepository.delete(saleItemId);
    }

    @Override
    public Set<SaleItem> getAll(){
        return this.saleItemRepository.getAll();
    }
}
