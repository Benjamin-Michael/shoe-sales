package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import za.ac.cput.entity.ModelLocation;

import za.ac.cput.repository.impl.ModelLocationRepository;

import java.util.Set;

public class ModelLocationService implements IModelLocationService{

    public static ModelLocationService modelLocationService = null;
    private ModelLocationRepository modelLocationRepository = null;

    private ModelLocationService(){
        this.modelLocationRepository = ModelLocationRepository.getRepository();
    }
    public static ModelLocationService getService(){
        if(modelLocationService == null)
            modelLocationService = new ModelLocationService();
        return modelLocationService;
    }

    @Override
    public ModelLocation create(ModelLocation modelLocation) {
        return this.modelLocationRepository.create(modelLocation);
    }

    @Override
    public ModelLocation read(String locationId) {
        return this.modelLocationRepository.read(locationId);
    }

    @Override
    public ModelLocation update(ModelLocation modelLocation) {
        return this.modelLocationRepository.update(modelLocation);
    }

    @Override
    public boolean delete(String locationId) {
        return this.modelLocationRepository.delete(locationId);
    }

    @Override
    public Set<ModelLocation> getAll() {
        return this.modelLocationRepository.getAll();
    }
}
