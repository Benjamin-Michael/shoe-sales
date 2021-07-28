package za.ac.cput.service.impl;

import za.ac.cput.entity.Shoe;
import za.ac.cput.repository.impl.ShoeRepository;

import java.util.Set;

public class ShoeService implements IShoeService{

    private static ShoeService shoeService = null;
    private ShoeRepository shoeRepository = null;

    private ShoeService(){
        this.shoeRepository = ShoeRepository.getRepository();
    }

    public static ShoeService getService(){
        if(shoeService == null)
            shoeService = new ShoeService();
        return shoeService;
    }

    @Override
    public Shoe create(Shoe shoe) {
        return this.shoeRepository.create(shoe);
    }

    @Override
    public Shoe read(String shoeId) {
        return this.shoeRepository.read(shoeId);
    }

    @Override
    public Shoe update(Shoe shoe) {
        return this.shoeRepository.update(shoe);
    }

    @Override
    public boolean delete(String shoeId) {
        return this.shoeRepository.delete(shoeId);
    }

    @Override
    public Set<Shoe> getAll() {
        return this.shoeRepository.getAll();
    }
}
