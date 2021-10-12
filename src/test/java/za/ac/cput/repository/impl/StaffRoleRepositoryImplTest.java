package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.factory.StaffRoleFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StaffRoleRepositoryImplTest {

    private static StaffRoleRepositoryImpl staffRoleRepositoryImp = StaffRoleRepositoryImpl.getRepository();
    private static StaffRole staffRole = StaffRoleFactory.createStaffRole("Floorist",GenericHelper.generateId());

    @Test
    void a_create() {
        StaffRole created = staffRoleRepositoryImp.create(staffRole);
        assertEquals(created.getRoleId(), staffRole.getRoleId());
        System.out.println("Created ID: " + created.getRoleId() + "\nRole ID: " + staffRole.getRoleId() + "\n");
    }

    @Test
    void b_read() {
        //a_create();
        StaffRole read = staffRoleRepositoryImp.read(staffRole.getRoleId());
        assertNotNull(read);
        System.out.println("Staff Read: " + read + "\n");
    }

    @Test
    void c_update() {
        StaffRole updated = new StaffRole.Builder().copy(staffRole).setStaffRole("Manager").build();
        assertNotNull(staffRoleRepositoryImp.update(updated));
        System.out.println("Updated StaffRole (" + updated.getRoleId() + "): " + updated.getStaffRole()
                + "\nOld StaffRole (" + staffRole.getRoleId() + "): " + staffRole.getStaffRole() + "\n");
    }

    @Test
    void e_delete() {
        //a_create();
        boolean deleted = staffRoleRepositoryImp.delete(staffRole.getRoleId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();
    }

    @Test
    void d_getAll(){
        System.out.println(staffRoleRepositoryImp.getAll() + "\n");
    }
}