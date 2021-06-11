package za.ac.cput.Factory;

import za.ac.cput.Entity.ShoeType;
import za.ac.cput.Util.GenericHelper;

public class ShoeTypeFactory {

    public static ShoeType createShoeType(String colour, double price){

        String shoeId = GenericHelper.generateId();

        ShoeType shoeType = new ShoeType.Builder()
                .setColour(colour)
                .setPrice(price)
                .build();

        return shoeType;
    }

}
