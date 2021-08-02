package za.ac.cput.service.impl;

import za.ac.cput.entity.ShoeType;
import za.ac.cput.repository.impl.ShoeTypeRepository;

import java.util.Set;

public class ShoeTypeService implements  IShoeTypeService{

    private static ShoeTypeService shoeTypeService = null;
    private ShoeTypeRepository shoeTypeRepository = null;

    private ShoeTypeService(){
        this.shoeTypeRepository = ShoeTypeRepository.getRepository();
    }

    public static ShoeTypeService getService(){
        if(shoeTypeService == null)
            shoeTypeService = new ShoeTypeService();
        return shoeTypeService;
    }

    @Override
    public ShoeType create(ShoeType shoeType) {
        return this.shoeTypeRepository.create(shoeType);
    }

    @Override
    public ShoeType read(String shoeTypeId) {
        return this.shoeTypeRepository.read(shoeTypeId);
    }

    @Override
    public ShoeType update(ShoeType shoeType) {
        return this.shoeTypeRepository.update(shoeType);
    }

    @Override
    public boolean delete(String shoeTypeId) {
        return this.shoeTypeRepository.delete(shoeTypeId);
    }

    @Override
    public Set<ShoeType> getAll() {
        return this.shoeTypeRepository.getAll();
    }
}
