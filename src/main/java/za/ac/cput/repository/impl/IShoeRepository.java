package za.ac.cput.repository.impl;

import za.ac.cput.entity.Shoe;
import za.ac.cput.repository.IRepository;

import java.util.Set;
@Deprecated
public interface IShoeRepository extends IRepository <Shoe, String> {
    public Set<Shoe> getAll();
}
