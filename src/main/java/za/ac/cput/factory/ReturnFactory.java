/*  ReturnFactory.java
    ReturnFactory
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Return;
import za.ac.cput.util.GenericHelper;

public class ReturnFactory {

    public static Return createReturn(String saleId, String returnDate){

        String returnId = GenericHelper.generateId();

        Return returns = new Return.Builder()
                .setReturnId(returnId)
                .setSaleId(saleId)
                .setReturnDate(returnDate)
                .build();

        return returns;
    }
}
