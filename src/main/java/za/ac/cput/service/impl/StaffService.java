package za.ac.cput.service.impl;
import za.ac.cput.entity.Staff;

import za.ac.cput.repository.impl.StaffRepositoryImpl;
import java.util.Set;

public class StaffService implements IStaffService{

    private static StaffService staffService = null ;
    private StaffRepositoryImpl staffRepositoryImpl = null;

    private StaffService(){
      // this.staffRepositoryImpl = StaffRepositoryImpl.getRepository();

    }

    public static StaffService getService(){
        if(staffService == null)
            staffService = new StaffService();
        return staffService;
    }

    @Override
    public Staff create(Staff staff) {
        return this.staffRepositoryImpl.create(staff);
    }

    @Override
    public Staff read(String staffId) {
        return this.staffRepositoryImpl.read(staffId);
    }

    @Override
    public Staff update(Staff staff) {
        return this.staffRepositoryImpl.update(staff);
    }

    @Override
    public boolean delete(String staffId) {
        return this.staffRepositoryImpl.delete(staffId);
    }

    @Override
    public Set<Staff> getAll() {
        return this.staffRepositoryImpl.getAll();
    }
}
