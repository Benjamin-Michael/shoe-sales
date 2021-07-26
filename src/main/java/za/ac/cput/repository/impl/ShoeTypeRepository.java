package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoeType;

import java.util.HashSet;
import java.util.Set;

public class ShoeTypeRepository implements IShoeTypeRepository{

    private Set<ShoeType> shoeTypeDB = null;

    public ShoeTypeRepository() {
        shoeTypeDB = new HashSet<ShoeType>();
    }

    @Override
    public ShoeType create(ShoeType shoeType) {
        this.shoeTypeDB.add(shoeType);
        return shoeType;
    }

    @Override
    public ShoeType read(String shoeTypeId) {
        ShoeType shoeType = null;

        for (ShoeType s : this.shoeTypeDB) {
            if (s.getShoeTypeId().equalsIgnoreCase(shoeTypeId)) {
                shoeType = s;
                break;
            }
        }

        return shoeType;
    }

    @Override
    public ShoeType update(ShoeType shoeType) {
        ShoeType preUpdate = read(shoeType.getShoeTypeId());

        if (preUpdate != null) {
            this.shoeTypeDB.remove(preUpdate);
            this.shoeTypeDB.add(shoeType);
        }

        return shoeType;
    }

    @Override
    public boolean delete(String shoeTypeId) {
        ShoeType shoeType = read(shoeTypeId);

        if (shoeType != null)
            this.shoeTypeDB.remove(shoeType);
        return true;
    }

    @Override
    public Set<ShoeType> getAll() {
        return shoeTypeDB;
    }
}
