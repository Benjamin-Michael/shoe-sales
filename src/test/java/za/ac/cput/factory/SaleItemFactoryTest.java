/*
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.SaleItem;
import static org.junit.jupiter.api.Assertions.*;

public class SaleItemFactoryTest {

    SaleItem saleItem1 = SaleItemFactory.createSaleItem("0001","SI0001");
    SaleItem saleItem2 = SaleItemFactory.createSaleItem("0002","SI0002");

    @Test
    void createSaleItem(){
        SaleItem saleItem1 = SaleItemFactory.createSaleItem("0001","SI0001");
        assertNotNull(saleItem1);
        System.out.println(saleItem1);
    }
    //equality test
    @Test
    void testEquality(){
        SaleItem saleItem1 = SaleItemFactory.createSaleItem("0001","SI0001");
        SaleItem saleItem2 = saleItem1;
        assertEquals(saleItem1,saleItem2);
    }

    //disabled
    @Disabled("disable for maintenance")
    @Test
    void testEqualityDisable(){
        SaleItem saleItem1 = SaleItemFactory.createSaleItem("0001","SI0001");
        SaleItem saleItem2 = saleItem1;
        assertEquals(saleItem1,saleItem2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        SaleItem saleItem1 = SaleItemFactory.createSaleItem("0001","SI0001");
        SaleItem saleItem2 = saleItem1;
        assertEquals(saleItem1,saleItem2);
    }

}
