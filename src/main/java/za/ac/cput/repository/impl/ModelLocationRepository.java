package za.ac.cput.repository.impl;

//AUTHOR: Lonwabo Alvin 217213685
import za.ac.cput.entity.ModelLocation;

import java.util.HashSet;
import java.util.Set;

public class ModelLocationRepository implements IModelLocationRepository {
    private Set<ModelLocation> ModelLocationDb =null;
    private static ModelLocationRepository repository = null;

    public ModelLocationRepository(){
        ModelLocationDb = new HashSet<ModelLocation>();
    }
    public static ModelLocationRepository getRepository(){
        if(repository == null)
            repository = new ModelLocationRepository();
        return repository;
    }
    @Override
    public ModelLocation create( ModelLocation modelLocation){
        this.ModelLocationDb.add(modelLocation);
        return modelLocation;
    }
    @Override
    public ModelLocation read(String locationId){
        ModelLocation modelLocation = null;

        for(ModelLocation ml : this.ModelLocationDb){
            if(ml.getLocationId().equalsIgnoreCase(locationId)){
                modelLocation = ml;
                break;
            }
        }
        return modelLocation;
    }
    @Override
    public ModelLocation update(ModelLocation modelLocation){
        ModelLocation ml = read(modelLocation.getLocationId());
        if(ml != null){
            this.ModelLocationDb.remove(ml);
            this.ModelLocationDb.add(modelLocation);
        }
        return modelLocation;
    }
    @Override
    public boolean delete(String locationId){
        ModelLocation modelLocation = read(locationId);
        if(modelLocation != null)
            this.ModelLocationDb.remove(modelLocation);
        return true;
    }
    @Override
    public Set<ModelLocation> getAll(){
        return ModelLocationDb;
    }
}
