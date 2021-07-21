/*
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class SaleFactoryTest {
    Sale sale1 = SaleFactory.createSale("0001","R 1000", "11 June 2021");
    Sale sale2 = SaleFactory.createSale("0002","R 2000", "5 June 2021");

    @Test
    void createSale(){
        Sale sale1 = SaleFactory.createSale("0001","R 1000", "11 June 2021");
        assertNotNull(sale1);
        System.out.println(sale1);
    }
    //equality test
    @Test
    void testEquality(){
        Sale sale1 = SaleFactory.createSale("0001","R 1000", "11 June 2021");
        Sale sale2 = sale1;
        assertEquals(sale1,sale2);
    }

    //disabled
    @Disabled("disable for maintenance")
    @Test
    void testEqualityDisable(){
        Sale sale1 = SaleFactory.createSale("0001","R 1000", "11 June 2021");
        Sale sale2 = sale1;
        assertEquals(sale1,sale2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        Sale sale1 = SaleFactory.createSale("0001","R 1000", "11 June 2021");
        Sale sale2 = sale1;
        assertEquals(sale1,sale2);
    }
}
