package za.ac.cput.repository.impl;
//AUTHOR: Lonwabo Alvin 217213685
import za.ac.cput.entity.Model;
import java.util.HashSet;
import java.util.Set;


public class ModelRepository implements IModelRepository {
    private Set<Model> ModelDb;
    private static ModelRepository repository = null;


    public ModelRepository()
    {
        ModelDb = new HashSet<Model>();
    }

    public static ModelRepository getRepository(){
        if(repository == null)
            repository = new ModelRepository();
        return repository;
    }

    public Model create(Model model){
        this.ModelDb.add(model);
        return model;
    }
    @Override
    public Model read(String modelId){
        Model model = null;

        for(Model m : this.ModelDb){
            if(m.getModelId().equalsIgnoreCase(modelId)){
                model = m;
                break;
            }
        }
        return model;
    }
    @Override
    public Model update(Model model){
        Model m = read(model.getModelId());
        if(m != null){
            this.ModelDb.remove(m);
            this.ModelDb.add(model);
        }
        return model;
    }
    @Override
    public boolean delete(String modelId){
        Model model = read(modelId);
        if(model != null)
            this.ModelDb.remove(model);
        return true;
    }
    @Override
    public Set<Model> getAll() {
        return this.ModelDb;
    }
}

