package za.ac.cput.repository.impl;

import za.ac.cput.entity.Staff;
/*StaffRepositoryImpl.java
  Repository implementation for staff class
  Author: Phindiwe Bambata (217180833)
  Date: 24/07/2021
 */

import java.util.HashSet;
import java.util.Set;
public class StaffRepositoryImpl implements StaffRepository{
    private static StaffRepository repository = null;
    private Set<Staff> staffDB;
   private StaffRepositoryImpl() { this.staffDB = new HashSet<>();}

    public static StaffRepository getRepository() {
        if(repository == null) repository = new StaffRepositoryImpl();
        return repository;
    }

    @Override
    public Staff create(Staff staff) {
        this.staffDB.add(staff);
        return staff;
    }

    @Override
    public Staff read(final String staffId) {
        for (Staff staff : this.staffDB) {
            if(staff.getStaffId().equalsIgnoreCase(staffId)) return staff;
        }
        return null;
    }

    @Override
    public Staff update(Staff staff) {
       Staff st = read(staff.getStaffId());
       if(st != null) {
           staffDB.remove(st);
           staffDB.add(staff);
            return staff;
       }
       return null;
    }

    @Override
    public boolean delete(String staffId) {
       Staff staff = read(staffId);
       if(staff != null) {
            this.staffDB.remove(staff);
            return true;
       }
        return false;
    }

    @Override
    public Set<Staff> getAll() {
        return this.staffDB;
   }
}

