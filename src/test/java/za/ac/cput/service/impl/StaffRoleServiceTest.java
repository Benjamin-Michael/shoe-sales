package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.factory.StaffRoleFactory;

import static org.junit.jupiter.api.Assertions.*;

class StaffRoleServiceTest {
    private static StaffRoleService staffRoleService = StaffRoleService.getService();
    private static StaffRole staffRole= StaffRoleFactory.createStaffRole("101","Create login");

    @Test
    void a_create() {
        StaffRole created = staffRoleService.create(staffRole);
        assertEquals(created.getRoleId(), staffRole.getRoleId());
        System.out.println("Created RoleID: " + created.getRoleId() + "\nStaffRole RoleID: " + staffRole.getRoleId() + "\n");
    }

    @Test
    void b_read() {
        StaffRole read = staffRoleService.read(staffRole.getStaffId());
        assertNotNull(read);
        System.out.println("StaffRole Read: " + read + "\n");
    }

    @Test
    void c_update() {
        StaffRole updated = new StaffRole.Builder().copy(staffRole).setRoleId("000").build();
        assertNotNull(staffRoleService.update(updated));
        System.out.println("Updated StaffRole (" + updated.getRoleId() + "): " + updated.getRoleDescription()
                + "\nOld StaffRole (" + staffRole.getRoleId() + "): " + staffRole.getStaffRole() + "\n");
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