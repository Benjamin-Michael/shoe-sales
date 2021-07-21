package za.ac.cput.repository.impl;

import za.ac.cput.entity.Shoe;
import za.ac.cput.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ShoeRepository implements IRepository <Shoe, String> {

    private List<Shoe> shoeList;

    public ShoeRepository() {
        shoeList = new ArrayList<>();
    }

    @Override
    public Shoe create(Shoe shoe) {
        this.shoeList.add(shoe);
        return shoe;
    }

    @Override
    public Shoe read(String shoeId) {
        Shoe shoe = null;

        for(Shoe s: this.shoeList){
            if(s.getShoeId().equalsIgnoreCase(shoeId)){
                shoe = s;
                break;
            }
        }

        return shoe;
    }

    @Override
    public Shoe update(Shoe shoe) {
        Shoe preUpdate = read(shoe.getShoeId());

        if(preUpdate != null){
            this.shoeList.remove(preUpdate);
            this.shoeList.add(shoe);
        }

        return shoe;
    }

    @Override
    public void delete(String shoeId) {
        Shoe shoe = read(shoeId);

        if(shoe != null)
            this.shoeList.remove(shoe);

    }
}
