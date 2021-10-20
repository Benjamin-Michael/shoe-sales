package za.ac.cput.repository.impl;

import za.ac.cput.entity.Staff;

import java.util.HashSet;
import java.util.Set;
@Deprecated

public class StaffRepositoryImp implements StaffRepository {

    private static StaffRepositoryImp repository = null;
    private Set<Staff> staffDB = null;

    private StaffRepositoryImp() {
        staffDB = new HashSet<Staff>();
    }

    public static StaffRepositoryImp getRepository(){
        if(repository == null)
            repository = new StaffRepositoryImp();
        return repository;
    }

    @Override
    public Staff create(Staff staff) {
        boolean success = this.staffDB.add(staff);
        if(!success)
            return null;

        return staff;
    }

    @Override
    public Staff read(String  staffId) {

        for (Staff staff : this.staffDB) {
            if (staff.getStaffId().equalsIgnoreCase(staffId))
                return staff;
        }

        return null;
    }

    @Override
    public Staff update(Staff staff) {
        Staff preUpdate = read(staff.getStaffId());

        if (preUpdate != null) {
            this.staffDB.remove(preUpdate);
            this.staffDB.add(staff);
            return staff;
        }

        return null;
    }

    @Override
    public boolean delete(String staffId) {
        Staff staffToDelete = read(staffId);

        if (staffToDelete != null) {
            this.staffDB.remove(staffToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Staff> getAll() {
        return staffDB;
    }
}

