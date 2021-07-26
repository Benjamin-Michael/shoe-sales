package za.ac.cput.repository.impl;

import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.ShoeSize;

import java.util.HashSet;
import java.util.Set;

public class ShoeSizeRepository implements IShoeSizeRepository {

    private static  ShoeSizeRepository repository = null;
    private Set<ShoeSize> shoeSizeDB = null;

    private ShoeSizeRepository() {
        shoeSizeDB = new HashSet<ShoeSize>();
    }

    public static ShoeSizeRepository getRepository(){
        if(repository == null)
            repository = new ShoeSizeRepository();
        return repository;
    }

    @Override
    public ShoeSize create(ShoeSize shoeSize) {
        boolean success = this.shoeSizeDB.add(shoeSize);
        if(!success)
            return null;

        return shoeSize;
    }

    @Override
    public ShoeSize read(String shoeSizeId) {
        for (ShoeSize shoeSize : this.shoeSizeDB) {
            if (shoeSize.getShoeSizeId().equalsIgnoreCase(shoeSizeId))
                return shoeSize;
        }

        return null;
    }

    @Override
    public ShoeSize update(ShoeSize shoeSize) {
        ShoeSize preUpdate = read(shoeSize.getShoeSizeId());

        if (preUpdate != null) {
            this.shoeSizeDB.remove(preUpdate);
            this.shoeSizeDB.add(shoeSize);
            return shoeSize;
        }

        return null;
    }

    @Override
    public boolean delete(String shoeSizeId) {
        ShoeSize shoeSizeToDelete = read(shoeSizeId);

        if (shoeSizeToDelete != null) {
            this.shoeSizeDB.remove(shoeSizeToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<ShoeSize> getAll() {
        return shoeSizeDB;
    }
}
