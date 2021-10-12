//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import za.ac.cput.entity.SaleItem;
import za.ac.cput.service.IService;
import java.util.Set;

public interface ISaleItemService extends IService<SaleItem, String> {
    public Set<SaleItem> getAll();
}
