package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import za.ac.cput.entity.Model;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IModelService extends IService<Model, String> {
    public Set<Model> getAll();
}

