package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.Staff;

import za.ac.cput.factory.StaffFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

class StaffRepositoryImplTest {

    private static StaffRepositoryImpl staffRepositoryImpl;
    private Staff staff;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
        Staff created = staffRepositoryImpl.create(staff);
        assertEquals(created.getStaffId(), staff.getStaffId());
        System.out.println("Created: " + created.getStaffId() + " = Staff: " + staff.getStaffId());
    }

    @Test
    void read() {
        Staff read = staffRepositoryImpl.read(staff.getStaffId());
        System.out.println("Staff Read: " + read);
    }

    @Test
    void update() {
        Staff updated = new Staff.Builder().copy(staff).setFirstName("Phindy").build();
        staffRepositoryImpl.update(updated);
        System.out.println("Updated (" + updated.getStaffId() + "): " + updated.getFirstName()
                + " = Staff: (" + staff.getStaffId() + "): " + staff.getFirstName());
    }

    @Test
    void delete() {
        staffRepositoryImpl.delete(staff.getStaffId());
        System.out.println("Deleted: " + staff.getStaffId());
    }
}

