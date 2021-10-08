package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Model;

import static org.junit.jupiter.api.Assertions.*;

class ModelFactoryTest {
     private Model model1, model2;

     @BeforeEach
     void setUp(){
         model1 = ModelFactory.createModel("98","Air max","Freshman's top achivement");
         model2 = null;
     }
    @Test
    void createModel(){
         model2 = ModelFactory.createModel("96","Air Jordans","Micheal Jordans 98 NBA design");
        assertNotNull(model2);
        System.out.println(model2);
    }
    @Disabled
    @Test
    void testCreation(){
        model1 = ModelFactory.createModel("98","Air max","Freshman's top achivement");
        assertNotNull(model1);
        System.out.println(model1);
    }
    @Timeout(1000)
    @Test
    void testObject(){
        model2 = model1;
        System.out.println(model2);

        assertAll(
                () -> assertEquals(model1, model2),
                () -> assertSame(model1, model2)
        );
    }



}