//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import za.ac.cput.entity.Sale;
import za.ac.cput.service.IService;
import java.util.Set;

public interface ISaleService extends IService<Sale,String> {
    public Set<Sale> getAll();
}
