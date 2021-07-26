//Author: Faidh Adams 215060148
package za.ac.cput.repository.impl;

import za.ac.cput.entity.SaleItem;

import java.util.HashSet;
import java.util.Set;

public class SaleItemRepository implements ISaleItemRepository {

    private Set<SaleItem> SaleItemDb = null;

    public SaleItemRepository() {
        SaleItemDb = new HashSet<SaleItem>();
    }

    //Create
    @Override
    public SaleItem create(SaleItem saleItem) {
        this.SaleItemDb.add(saleItem);
        return saleItem;
    }

    //Read
    @Override
    public SaleItem read(String saleItemId) {
        SaleItem saleItem = null;

        for (SaleItem si : this.SaleItemDb) {
            if (si.getSaleItemId().equalsIgnoreCase(saleItemId)) {
                saleItem = si;
                break;
            }
        }

        return saleItem;
    }

    //Update
    @Override
    public SaleItem update(SaleItem saleItem) {
        SaleItem si = read(saleItem.getSaleItemId());

        if (si != null) {
            this.SaleItemDb.remove(si);
            this.SaleItemDb.add(saleItem);
        }

        return saleItem;
    }

    //Delete
    @Override
    public boolean delete(String saleItemId) {
        SaleItem saleItem = read(saleItemId);

        if (saleItem != null)
            this.SaleItemDb.remove(saleItem);
        return true;
    }

    @Override
    public Set<SaleItem> getAll() {
        return SaleItemDb;
    }
}
