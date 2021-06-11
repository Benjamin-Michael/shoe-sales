/*  SaleFactory.java
    SaleFactory
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Sale;
import za.ac.cput.Util.GenericHelper;

public class SaleFactory {

    public static Sale createSale(String staffId, String saleTotal, String saleDate){

        String saleId = GenericHelper.generateId();

        Sale sale = new Sale.Builder()
                .setSaleId(saleId)
                .setStaffId(staffId)
                .setSaleTotal(saleTotal)
                .setSaleDate(saleDate)
                .build();

        return sale;
    }

}
