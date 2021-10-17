package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Shoe;
import za.ac.cput.repository.ShoeRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoeService implements IShoeService{

    private static ShoeService shoeService = null;

    @Autowired
    private ShoeRepository shoeRepository;

    @Override
    public Shoe create(Shoe shoe) {
        return this.shoeRepository.save(shoe);
    }

    @Override
    public Shoe read(String shoeId) {
        return this.shoeRepository.findById(shoeId).orElse(null);
    }

    @Override
    public Shoe update(Shoe shoe) {
        if(this.shoeRepository.existsById(shoe.getShoeId()))
            return this.shoeRepository.save(shoe);
        return null;
    }

    @Override
    public boolean delete(String shoeId) {
        this.shoeRepository.deleteById(shoeId);

        if(this.shoeRepository.existsById(shoeId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Shoe> getAll() {
        return this.shoeRepository.findAll().stream().collect(Collectors.toSet());
    }
}
