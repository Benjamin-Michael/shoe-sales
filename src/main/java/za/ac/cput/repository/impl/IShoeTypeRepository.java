package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoeType;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IShoeTypeRepository extends IRepository<ShoeType,String> {
    public Set<ShoeType> getAll();
}
