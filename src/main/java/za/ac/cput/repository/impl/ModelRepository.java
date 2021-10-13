package za.ac.cput.repository.impl;

import za.ac.cput.entity.Model;
import java.util.HashSet;
import java.util.Set;


public class ModelRepository implements IModelRepository {
    private static ModelRepository repository;
    private Set<Model> modelDB;

    private ModelRepository() { modelDB = new HashSet<Model>();}

    public static IModelRepository getRepository() {
        if(repository == null)
            repository = new ModelRepository();
        return repository;
    }

    @Override
    public Model create(Model model) {
        this.modelDB.add(model);

        return model;
    }

    @Override
    public Model read(final String modeId) {
        for (Model model : this.modelDB) {
            if(model.getModelId().equalsIgnoreCase(modeId)) return model;
        }
        return null;
    }

    @Override
    public Model update(Model model) {
        Model modelUpdate = read(model.getModelId());
        if(modelUpdate != null) {
            modelDB.remove(model);
            modelDB.add(model);
            return model;
        }
        return null;
    }

    @Override
    public boolean delete(String modelId) {
        Model modelDeleted = read(modelId);
        if(modelId!= null) {
            this.modelDB.remove(modelDeleted);
            return true;
        }
        return false;
    }

    @Override
    public Set<Model> getAll() {
        return this.modelDB;
    }
}
