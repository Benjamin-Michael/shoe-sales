package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import za.ac.cput.entity.ModelLocation;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IModelLocationService extends IService <ModelLocation, String>{
    public Set<ModelLocation> getAll();
}
