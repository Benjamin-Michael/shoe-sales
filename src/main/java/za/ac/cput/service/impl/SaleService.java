//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Sale;
import za.ac.cput.repository.SaleRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService{

    private static SaleService saleService = null;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale create(Sale sale){
        return this.saleRepository.save(sale);
    }

    @Override
    public Sale read(String saleId) {
        return this.saleRepository.findById(saleId).orElse(null);
    }

    @Override
    public Sale update(Sale sale) {
        if(this.saleRepository.existsById(sale.getSaleId()))
            return this.saleRepository.save(sale);
        return null;
    }

    @Override
    public boolean delete(String saleId) {
        this.saleRepository.deleteById(saleId);

        if(this.saleRepository.existsById(saleId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Sale> getAll(){
        return this.saleRepository.findAll().stream().collect(Collectors.toSet());
    }
}
