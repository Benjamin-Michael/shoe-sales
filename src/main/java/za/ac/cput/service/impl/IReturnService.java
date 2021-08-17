//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import za.ac.cput.entity.Return;
import za.ac.cput.service.IService;
import java.util.Set;

public interface IReturnService extends IService<Return, String> {
    public Set<Return> getAll();
}
