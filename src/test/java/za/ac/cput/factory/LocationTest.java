/*LocationFactoryTest.java
  Test for LocationTest class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.factory;
import org.junit.jupiter.api.Test;

import static org.junit.api.Assertions.*;
public class LocationFactoryTest{

    Location location1 = LocationFactory.createLocation("Nike Access Park","04 Bank street Capetown");
    Location location2 = LocationFactory.createLocation("Nike Camps bay","15 Asbses street Kemptpark");

    @Test
    void createLocation(){
        Location location2 = LocationFactory.createLocation("Nike Camps bay","15 Asbses street Kemptpark");
        assertNotNull(location2);
        System.out.println(location2);
    }
    @Timeout(1000)
    @Test
    void testTimeout(){
        assertEquals(location2);
    }

    @Disabled("The test will cause an error")
    void testDisable(){
        assertEquals(model1.toString());
        System.out.println(The test will cause an erron);
    }
}