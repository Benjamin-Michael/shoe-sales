//Author: Faidh Adams 215060148
package za.ac.cput.repository.impl;

import za.ac.cput.entity.Return;
import za.ac.cput.repository.IRepository;
import java.util.Set;

public interface IReturnRepository extends IRepository<Return, String> {
    public Set<Return> getAll();
}
