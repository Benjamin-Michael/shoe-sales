package za.ac.cput.Factory;

import za.ac.cput.Entity.ShoeSize;
import za.ac.cput.Util.GenericHelper;

public class ShoeSizeFactory {

    public static ShoeSize createShoeSize(int size){

        String shoeId = GenericHelper.generateId();

        ShoeSize shoeSize = new ShoeSize.Builder()
                .setSize(size)
                .build();

        return shoeSize;
    }

}
