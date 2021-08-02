package za.ac.cput.service.impl;

import za.ac.cput.entity.ShoeSize;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IShoeSizeService extends IService<ShoeSize, String> {
    public Set<ShoeSize> getAll();
}
