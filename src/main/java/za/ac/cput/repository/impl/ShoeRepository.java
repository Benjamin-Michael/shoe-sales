package za.ac.cput.repository.impl;

import za.ac.cput.entity.Shoe;

import java.util.HashSet;
import java.util.Set;

@Deprecated
public class ShoeRepository implements IShoeRepository {

    private static ShoeRepository repository = null;
    private Set<Shoe> shoeDB = null;

    private ShoeRepository() {
        shoeDB = new HashSet<Shoe>();
    }

    public static ShoeRepository getRepository(){
        if(repository == null)
            repository = new ShoeRepository();
        return repository;
    }

    @Override
    public Shoe create(Shoe shoe) {
        boolean success = this.shoeDB.add(shoe);
        if(!success)
            return null;

        return shoe;
    }

    @Override
    public Shoe read(String shoeId) {

        for (Shoe shoe : this.shoeDB) {
            if (shoe.getShoeId().equalsIgnoreCase(shoeId))
                return shoe;
        }

        return null;
    }

    @Override
    public Shoe update(Shoe shoe) {
        Shoe preUpdate = read(shoe.getShoeId());

        if (preUpdate != null) {
            this.shoeDB.remove(preUpdate);
            this.shoeDB.add(shoe);
            return shoe;
        }

        return null;
    }

    @Override
    public boolean delete(String shoeId) {
        Shoe shoeToDelete = read(shoeId);

        if (shoeToDelete != null) {
            this.shoeDB.remove(shoeToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Shoe> getAll() {
        return shoeDB;
    }
}

