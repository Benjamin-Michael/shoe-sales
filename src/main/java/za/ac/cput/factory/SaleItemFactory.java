/*  SaleItemFactory.java
    SaleItemFactory
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.SaleItem;
import za.ac.cput.util.GenericHelper;

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
