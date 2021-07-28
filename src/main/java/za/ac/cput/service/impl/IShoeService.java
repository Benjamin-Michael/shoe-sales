package za.ac.cput.service.impl;

import za.ac.cput.entity.Shoe;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IShoeService extends IService <Shoe, String> {
    public Set<Shoe> getAll();
}
