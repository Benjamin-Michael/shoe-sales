package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;

import static org.junit.jupiter.api.Assertions.*;

class StaffRoleRepositoryImplTest {

    private static StaffRoleRepositoryImpl staffRoleRepositoryImpl;
    private StaffRole staffRole;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
        StaffRole created = staffRoleRepositoryImpl.create(staffRole);
        assertEquals(created.getRoleId(), staffRole.getRoleId());
        System.out.println("Created: " + created.getRoleId() + " = StaffRole: " + staffRole.getRoleId());
    }

    @Test
    void read() {
        StaffRole read = staffRoleRepositoryImpl.read(staffRole.getRoleId());
        System.out.println("StaffRole Read: " + read);
    }

    @Test
    void update() {
        StaffRole updated = new StaffRole.Builder().copy(staffRole).setStaffRole("Technician").build();
        staffRoleRepositoryImpl.update(updated);
        System.out.println("Updated (" + updated.getRoleId() + "): " + updated.getStaffRole()
                + " = StaffRole: (" + staffRole.getRoleId() + "): " + staffRole.getStaffRole());
    }

    @Test
    void delete() {
        staffRoleRepositoryImpl.delete(staffRole.getRoleId());
        System.out.println("Deleted: " + staffRole.getRoleId());
    }
}

