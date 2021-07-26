package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoeSize;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IShoeSizeRepository extends IRepository<ShoeSize, String> {
    public Set<ShoeSize> getAll();
}
