/*  ShoeSizeFactory.java
    ShoeSizeFactory
    Author: Michael Benjamin (219071438)
    Date: 11 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.ShoeSize;
import za.ac.cput.Util.GenericHelper;

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
