package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.factory.StaffRoleFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StaffRoleServiceTest {

    private static StaffRoleService staffRoleService = StaffRoleService.getService();
    private static StaffRole staffRole = StaffRoleFactory.createStaffRole(GenericHelper.generateId(),"Fix computer");

    @Test
    void a_create() {
        StaffRole created = staffRoleService.create(staffRole);
        assertEquals(created.getRoleId(), staffRole.getRoleId());
        System.out.println("Created ID: " + created.getRoleId() + "\nStaffRole ID: " + staffRole.getRoleId() + "\n");
    }

    @Test
    void b_read() {
        StaffRole read = staffRoleService.read(staffRole.getRoleId());
        assertNotNull(read);
        System.out.println("staffRole Read: " + read + "\n");
    }

    @Test
    void c_update() {
        StaffRole updated = new StaffRole.Builder().copy(staffRole).setRoleDescription("Cleans the shop").build();
        assertNotNull(staffRoleService.update(updated));
        System.out.println("Updated StaffRole (" + updated.getRoleId() + "): " + updated.getRoleDescription()
                + "\nOld StaffRole (" + staffRole.getRoleId() + "): " + staffRole.getRoleDescription() + "\n");
    }

    @Test
    void e_delete() {
        boolean deleted = staffRoleService.delete(staffRole.getRoleId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll() {
        System.out.println(staffRoleService.getAll() + "\n");
    }

}