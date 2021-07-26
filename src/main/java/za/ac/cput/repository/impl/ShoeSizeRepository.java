package za.ac.cput.repository.impl;

import za.ac.cput.entity.ShoeSize;

import java.util.HashSet;
import java.util.Set;

public class ShoeSizeRepository implements IShoeSizeRepository {

    private Set<ShoeSize> shoeSizeDB = null;

    public ShoeSizeRepository() {
        shoeSizeDB = new HashSet<ShoeSize>();
    }

    @Override
    public ShoeSize create(ShoeSize shoeSize) {
        this.shoeSizeDB.add(shoeSize);
        return shoeSize;
    }

    @Override
    public ShoeSize read(String shoeSizeId) {
        ShoeSize shoeSize = null;

        for (ShoeSize s : this.shoeSizeDB) {
            if (s.getShoeSizeId().equalsIgnoreCase(shoeSizeId)) {
                shoeSize = s;
                break;
            }
        }

        return shoeSize;
    }

    @Override
    public ShoeSize update(ShoeSize shoeSize) {
        ShoeSize preUpdate = read(shoeSize.getShoeSizeId());

        if (preUpdate != null) {
            this.shoeSizeDB.remove(preUpdate);
            this.shoeSizeDB.add(shoeSize);
        }

        return shoeSize;
    }

    @Override
    public boolean delete(String shoeSizeId) {
        ShoeSize shoeSize = read(shoeSizeId);

        if (shoeSize != null)
            this.shoeSizeDB.remove(shoeSize);
        return true;
    }

    @Override
    public Set<ShoeSize> getAll() {
        return shoeSizeDB;
    }
}
