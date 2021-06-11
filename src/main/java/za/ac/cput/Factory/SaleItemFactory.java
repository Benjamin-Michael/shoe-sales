/*  SaleItemFactory.java
    SaleItemFactory
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.SaleItem;
import za.ac.cput.Util.GenericHelper;

public class SaleItemFactory {
    public static SaleItem createSaleItem(String shoeId, String saleId){

        String saleItemId = GenericHelper.generateId();

        SaleItem saleItem = new SaleItem.Builder()
                .setSaleItemId(saleItemId)
                .setShoeId(shoeId)
                .setSaleId(saleId)
                .build();

        return saleItem;
    }
}
