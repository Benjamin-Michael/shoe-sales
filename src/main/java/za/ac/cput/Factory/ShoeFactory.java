/*  ShoeFactory.java
    ShoeFactory
    Author: Michael Benjamin (219071438)
    Date: 10 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Shoe;
import za.ac.cput.Util.GenericHelper;

public class ShoeFactory {

    public static Shoe createShoe(String brand, String modelId, String shoeTypeId, String shoeSizeId){

        String shoeId = GenericHelper.generateId();

        Shoe shoe = new Shoe.Builder()
                .setShoeId(shoeId)
                .setBrand(brand)
                .setModelId(modelId)
                .setShoeTypeId(shoeTypeId)
                .setShoeSizeId(shoeSizeId)
                .build();

        return shoe;
    }
}
