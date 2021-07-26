package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoeSize;
import za.ac.cput.entity.ShoeType;

import java.util.HashSet;
import java.util.Set;

public class ShoeTypeRepository implements IShoeTypeRepository{

    private static  ShoeTypeRepository repository = null;
    private Set<ShoeType> shoeTypeDB = null;

    private ShoeTypeRepository() {
        shoeTypeDB = new HashSet<ShoeType>();
    }

    public static ShoeTypeRepository getRepository(){
        if(repository == null)
            repository = new ShoeTypeRepository();
        return repository;
    }

    @Override
    public ShoeType create(ShoeType shoeType) {
        boolean success = this.shoeTypeDB.add(shoeType);
        if(!success)
            return null;

        return shoeType;
    }

    @Override
    public ShoeType read(String shoeTypeId) {
        for (ShoeType shoeType : this.shoeTypeDB) {
            if (shoeType.getShoeTypeId().equalsIgnoreCase(shoeTypeId))
                return shoeType;
        }

        return null;
    }

    @Override
    public ShoeType update(ShoeType shoeType) {
        ShoeType preUpdate = read(shoeType.getShoeTypeId());

        if (preUpdate != null) {
            this.shoeTypeDB.remove(preUpdate);
            this.shoeTypeDB.add(shoeType);
            return shoeType;
        }

        return null;
    }

    @Override
    public boolean delete(String shoeTypeId) {
        ShoeType shoeTypeToDelete = read(shoeTypeId);

        if (shoeTypeToDelete != null) {
            this.shoeTypeDB.remove(shoeTypeToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<ShoeType> getAll() {
        return shoeTypeDB;
    }
}
