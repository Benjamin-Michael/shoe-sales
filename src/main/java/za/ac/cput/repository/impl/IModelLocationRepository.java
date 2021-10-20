package za.ac.cput.repository.impl;
//AUTHOR: Lonwabo Alvin 217213685

import za.ac.cput.entity.ModelLocation;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IModelLocationRepository extends IRepository<ModelLocation, String> {
    public Set<ModelLocation> getAll();
}
