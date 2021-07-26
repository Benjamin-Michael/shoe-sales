//Author: Faidh Adams 215060148
package za.ac.cput.repository.impl;

import za.ac.cput.entity.SaleItem;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ISaleItemRepository extends IRepository<SaleItem, String> {
    public Set<SaleItem> getAll();
}
