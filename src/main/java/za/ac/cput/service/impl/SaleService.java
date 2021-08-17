//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Sale;
import za.ac.cput.repository.impl.SaleRepository;

import java.util.Set;

@Service
public class SaleService implements ISaleService{

    private static SaleService saleService = null;
    private SaleRepository saleRepository = null;

    private SaleService(){
        this.saleRepository = SaleRepository.getRepository();
    }

    public static SaleService getService(){
        if(saleService == null)
            saleService = new SaleService();
        return saleService;
    }

    @Override
    public Sale create(Sale sale){
        return this.saleRepository.create(sale);
    }

    @Override
    public Sale read(String saleId) {
        return this.saleRepository.read(saleId);
    }

    @Override
    public Sale update(Sale sale) {
        return this.saleRepository.update(sale);
    }

    @Override
    public boolean delete(String saleId) {
        return this.saleRepository.delete(saleId);
    }

    @Override
    public Set<Sale> getAll(){
        return this.saleRepository.getAll();
    }
}
