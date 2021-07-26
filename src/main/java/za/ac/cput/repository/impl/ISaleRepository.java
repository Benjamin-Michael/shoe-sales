//Author: Faidh Adams 215060148
package za.ac.cput.repository.impl;

import za.ac.cput.entity.Sale;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ISaleRepository extends IRepository<Sale, String> {
    public Set<Sale> getAll();
}
