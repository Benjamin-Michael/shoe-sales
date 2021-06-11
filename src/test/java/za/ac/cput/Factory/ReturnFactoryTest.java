/*
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Return;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnFactoryTest {
    Return returns1 = ReturnFactory.createReturn("0001","20 June 2021");
    Return returns2 = ReturnFactory.createReturn("0002","9 June 2021");

    @Test
    void createReturn(){
        Return returns1 = ReturnFactory.createReturn("0001","20 June 2021");
        assertNotNull(returns1);
        System.out.println(returns1);
    }
    //equality test
    @Test
    void testEquality(){
        Return returns1 = ReturnFactory.createReturn("0001","20 June 2021");
        Return returns2 = returns1;
        assertEquals(returns1,returns2);
    }

    //disabled
    @Disabled("disable for maintenance")
    @Test
    void testEqualityDisable(){
        Return returns1 = ReturnFactory.createReturn("0001","20 June 2021");
        Return returns2 = returns1;
        assertEquals(returns1,returns2);
    }

    @Timeout(1000)
    @Test
    void testTimeout()throws InterruptedException{
        Thread.sleep(1000);

        Return returns1 = ReturnFactory.createReturn("0001","20 June 2021");
        Return returns2 = returns1;
        assertEquals(returns1,returns2);
    }
}
