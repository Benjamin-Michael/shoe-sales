/*  ShoeSizeFactory.java
    ShoeSizeFactory
    Author: Michael Benjamin (219071438)
    Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.ShoeSize;
import za.ac.cput.util.GenericHelper;

public class ShoeSizeFactory {

    public static ShoeSize createShoeSize(int size, boolean adultSize){

        String shoeSizeId = GenericHelper.generateId();

        ShoeSize shoeSize = new ShoeSize.Builder()
                .setSizeId(shoeSizeId)
                .isAdultSize(adultSize)
                .setSize(size)
                .build();

        return shoeSize;
    }

}
