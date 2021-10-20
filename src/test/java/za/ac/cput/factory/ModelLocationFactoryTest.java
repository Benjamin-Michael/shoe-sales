package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.ModelLocation;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ModelLocationFactoryTest {
    private ModelLocation MLocation1, MLocation2,MLocation3;

    @BeforeEach
    void setUp() {
        MLocation1 = ModelLocationFactory.createModelLocation("96.8", "Nike", "300");
        MLocation3 = ModelLocationFactory.createModelLocation("90.1", "Puma", "160");
    }

    @Test
    void createModelLocation() {
        MLocation2 = ModelLocationFactory.createModelLocation("96.8", "Nike", "300");
        assertNotNull(MLocation2);
        System.out.println(MLocation2);
    }

    @Test
    void testIdentity() {
        assertNotSame(MLocation1, MLocation3);
    }
    @Test
    void testEquality() {
        assertNotEquals(MLocation1, MLocation2);

    }
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void timeout() {
        assertNotEquals(MLocation1, MLocation2);
        assertNotSame(MLocation1, MLocation2);
    }
    @Disabled
    @Test
    void disableTest(){
        assertEquals(MLocation1, MLocation2);
    }

}