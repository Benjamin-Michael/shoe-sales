package za.ac.cput.repository.impl;

import za.ac.cput.entity.Shoe;

import java.util.HashSet;
import java.util.Set;

public class ShoeRepository implements IShoeRepository {

    private Set<Shoe> shoeDB = null;

    public ShoeRepository() {
        shoeDB = new HashSet<Shoe>();
    }

    @Override
    public Shoe create(Shoe shoe) {
        this.shoeDB.add(shoe);
        return shoe;
    }

    @Override
    public Shoe read(String shoeId) {
        Shoe shoe = null;

        for (Shoe s : this.shoeDB) {
            if (s.getShoeId().equalsIgnoreCase(shoeId)) {
                shoe = s;
                break;
            }
        }

        return shoe;
    }

    @Override
    public Shoe update(Shoe shoe) {
        Shoe preUpdate = read(shoe.getShoeId());

        if (preUpdate != null) {
            this.shoeDB.remove(preUpdate);
            this.shoeDB.add(shoe);
        }

        return shoe;
    }

    @Override
    public boolean delete(String shoeId) {
        Shoe shoe = read(shoeId);

        if (shoe != null)
            this.shoeDB.remove(shoe);
          return true;
    }

    @Override
    public Set<Shoe> getAll() {
        return shoeDB;
    }
}

