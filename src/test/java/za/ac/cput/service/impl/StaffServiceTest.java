package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.MethodName.class)
    class StaffServiceTest {

        private static StaffService staffService = StaffService.getService();
        private static Staff staff = StaffFactory.createStaff(GenericHelper.generateId(),"Spider","Man");

        @Test
        void a_create() {
            Staff created = staffService.create(staff);
            assertEquals(created.getStaffId(), staff.getStaffId());
            System.out.println("Created ID: " + created.getStaffId() + "\nStaff ID: " + staff.getStaffId() + "\n");
        }

        @Test
        void b_read() {
            Staff read = staffService.read(staff.getStaffId());
            assertNotNull(read);
            System.out.println("staff Read: " + read + "\n");
        }

        @Test
        void c_update() {
            Staff updated = new Staff.Builder().copy(staff).setFirstName("Hulk").build();
            assertNotNull(staffService.update(updated));
            System.out.println("Updated Staff (" + updated.getStaffId() + "): " + updated.getFirstName()
                    + "\nOld Staff (" + staff.getStaffId() + "): " + staff.getFirstName() + "\n");
        }

        @Test
        void e_delete() {
            boolean deleted = staffService.delete(staff.getStaffId());
            assertTrue(deleted);
            System.out.println("Deleted: " + deleted);
            d_getAll();
        }

        @Test
        void d_getAll() {
            System.out.println(staffService.getAll() + "\n");
        }

}