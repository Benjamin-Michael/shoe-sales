/*ModelFactoryTest.java
  Factory for ModelTest class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.factory;
import org.junit.jupiter.api.Test;

import static org.junit.api.Assertions.*;
public class ModelLocationFactoryTest{

    ModelLocation model1 = ModelLocationFactory.createModelLocation("96.8","Nike","300");
    ModelLocation model2 = ModelLocationFactory.createModelLocation("98.1","Nike","200");

    @Test
    void createModelLocation(){
        Model model1 = ModelLocationFactory.createModelLocation("96.8","Nike","300");
        assertNotNull(model1);
        System.out.println(model1);
    }
    @Timeout(1000)
    @Test
    void testTimeout(){
        assertEquals(model1);
    }

    @Disabled("The test will not execute")
    void testDisable(){
        assertEquals(model1.toString());
        System.out.println(The test will cause an erron);
    }
}