package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Location;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {
      private Location Slocation1,Slocation2,Slocation3;


      @BeforeEach
      void setUp(){
          Slocation1 = LocationFactory.createLocation("23 Asbes Cape Town");
          Slocation3 = LocationFactory.createLocation("30 Dorset Bellville");
      }
      @Test
      void createLocation(){
          Slocation2 = LocationFactory.createLocation("20 Burga Cape gate");
          assertNotNull(Slocation2);
          System.out.println(Slocation2);
      }
    @Test
    void testIdentity() {
        assertNotSame(Slocation1, Slocation3);
    }
    @Test
    void testEquality() {
        assertNotEquals(Slocation1, Slocation2);

    }
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void timeout() {
        assertNotEquals(Slocation1, Slocation2);
        assertNotSame(Slocation1, Slocation2);
    }
    @Disabled
    @Test
    void disableTest(){
        assertEquals(Slocation1, Slocation2);
    }

}