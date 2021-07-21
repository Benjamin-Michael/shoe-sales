/*ModelFactoryTest.java
  Factory for ModelTest class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.factory;
import org.junit.jupiter.api.Test;

import static org.junit.api.Assertions.*;
public class ModelFactoryTest{

    Model model1 = ModelFactory.createModel("96","Air Jordans","Micheal Jordans 98 NBA design");
    Model model2 = ModelFactory.createModel("98","Air max","Freshman's top achivement");

    @Test
    void createModel(){
        Model model1 = ModelFactory.createModel("96","Air Jordans","Micheal Jordans 98 NBA design");
        assertNotNull(model1);
        System.out.println(model1);
    }
    @Timeout(1000)
    @Test
    void testTimeout(){
        assertEquals(model1);
    }

    @Disabled("The test will cause an error")
    void testDisable(){
        assertEquals(model1.toString());
        System.out.println(The test will cause an erron);
    }
}