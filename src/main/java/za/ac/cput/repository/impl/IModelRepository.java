package za.ac.cput.repository.impl;


import za.ac.cput.entity.Model;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IModelRepository extends IRepository<Model, String>
{
    public Set<Model> getAll();
}

