package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.StaffRole;
import za.ac.cput.Util.GenericHelper;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class StaffRoleFactoryTest {
    private StaffRole role1, role2, role3;

    @BeforeEach
    void setUp() {
        role1 = StaffRoleFactory.createStaffRole("Manager", "Book keeping");
        role2 = role1;
    }


    @Test
    public void createStaffRole() {
        role3 = StaffRoleFactory.createStaffRole("Adminstrator", "Logging queries");
        assertNotNull(role3);

    }

    @Test
    void testIdentity() {
        assertSame(role2,role1);

    }
    @Test
    void testEquality() {
        assertEquals(role1, role2);

    }
    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void timeout() {
        assertNotEquals(role1, role3);
        assertNotSame(role2, role3);
    }
    @Disabled
    @Test
    void disableTest(){
        assertEquals(role1,role2);

    }
}