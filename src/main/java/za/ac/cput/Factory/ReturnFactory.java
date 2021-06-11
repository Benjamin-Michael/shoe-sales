/*  ReturnFactory.java
    ReturnFactory
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Return;
import za.ac.cput.Util.GenericHelper;

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
