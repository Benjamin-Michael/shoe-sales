//Author: Faidh Adams 215060148
package za.ac.cput.repository.impl;

import za.ac.cput.entity.Sale;

import java.util.HashSet;
import java.util.Set;

public class SaleRepository implements ISaleRepository{
    private Set<Sale> SaleDb = null;

    public SaleRepository() {
        SaleDb = new HashSet<Sale>();
    }

    //Create
    @Override
    public Sale create(Sale sale) {
        this.SaleDb.add(sale);
        return sale;
    }

    //Read
    @Override
    public Sale read(String saleId) {
        Sale sale = null;

        for (Sale s : this.SaleDb) {
            if (s.getSaleId().equalsIgnoreCase(saleId)) {
                sale = s;
                break;
            }
        }

        return sale;
    }

    //Update
    @Override
    public Sale update(Sale sale) {
        Sale s = read(sale.getSaleId());

        if (s != null) {
            this.SaleDb.remove(s);
            this.SaleDb.add(sale);
        }

        return sale;
    }

    //Delete
    @Override
    public boolean delete(String saleId) {
        Sale sale = read(saleId);

        if (sale != null)
            this.SaleDb.remove(sale);
        return true;
    }

    @Override
    public Set<Sale> getAll() {
        return SaleDb;
    }
}
