package za.ac.cput.service.impl;

import za.ac.cput.entity.ShoeSize;
import za.ac.cput.repository.impl.ShoeSizeRepository;

import java.util.Set;

public class ShoeSizeService implements IShoeSizeService{

    private static ShoeSizeService shoeSizeService = null;
    private ShoeSizeRepository shoeSizeRepository = null;

    private ShoeSizeService(){
        this.shoeSizeRepository = ShoeSizeRepository.getRepository();
    }

    public static ShoeSizeService getService(){
        if(shoeSizeService == null)
            shoeSizeService = new ShoeSizeService();
        return shoeSizeService;
    }

    @Override
    public ShoeSize create(ShoeSize shoeSize) {
        return this.shoeSizeRepository.create(shoeSize);
    }

    @Override
    public ShoeSize read(String shoeSizeId) {
        return this.shoeSizeRepository.read(shoeSizeId);
    }

    @Override
    public ShoeSize update(ShoeSize shoeSize) {
        return this.shoeSizeRepository.update(shoeSize);
    }

    @Override
    public boolean delete(String shoeSizeId) {
        return this.shoeSizeRepository.delete(shoeSizeId);
    }

    @Override
    public Set<ShoeSize> getAll() {
        return this.shoeSizeRepository.getAll();
    }
}
