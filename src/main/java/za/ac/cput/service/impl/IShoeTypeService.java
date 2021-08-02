package za.ac.cput.service.impl;

import za.ac.cput.entity.ShoeType;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IShoeTypeService extends IService<ShoeType, String> {
    public Set<ShoeType> getAll();
}
