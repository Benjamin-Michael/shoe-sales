package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Staff;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class StaffFactoryTest {
  private Staff staff1,staff2,staff3;

    @BeforeEach
    void setUp() {
        staff1 = StaffFactory.createStaff("Phindiwe", "Bambata");
        staff3 = StaffFactory.createStaff( "Toya", "Sangoni");

    }

    @Test
    public void createStaff() {
        staff2 = StaffFactory.createStaff("Zinzi","Boyce");
        assertNotNull(staff2);
        System.out.println(staff2);
    }
    @Test
    void testIdentity() {
        assertNotSame(staff1, staff3);
    }
    @Test
    void testEquality() {
        assertNotEquals(staff1, staff2);

    }
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void timeout() {
        assertNotEquals(staff1, staff2);
        assertNotSame(staff1, staff2);
    }
    @Disabled
    @Test
    void disableTest(){
        assertEquals(staff1,staff2);

    }
}