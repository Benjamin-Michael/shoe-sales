package za.ac.cput.service.impl;

import za.ac.cput.entity.Model;
import za.ac.cput.repository.impl.ModelRepository;
//AUTHOR: Lonwabo Alvin 217213685
import java.util.Set;

public class ModelService implements IModelService{

    public static ModelService modelService = null;
    private ModelRepository modelRepository = null;

    private ModelService(){
        this.modelRepository = ModelRepository.getRepository();
    }
    public static ModelService getService(){
        if(modelService == null)
            modelService = new ModelService();
        return modelService;
    }

    @Override
    public Model create(Model model) {
        return this.modelRepository.create(model);
    }

    @Override
    public Model read(String modelId) {
        return this.modelRepository.read(modelId);
    }

    @Override
    public Model update(Model model) {
        return this.modelRepository.update(model);
    }

    @Override
    public boolean delete(String modelId) {
        return this.modelRepository.delete(modelId);
    }

    @Override
    public Set<Model> getAll() {
        return this.modelRepository.getAll();
    }
}
