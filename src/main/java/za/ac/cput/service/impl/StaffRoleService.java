package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;
import za.ac.cput.repository.impl.StaffRepositoryImp;
import za.ac.cput.repository.impl.StaffRoleRepositoryImpl;

import java.util.Set;

@Service
public class StaffRoleService implements IStaffRoleService{

    private static StaffRoleService staffRoleService = null;
    private StaffRoleRepositoryImpl staffRoleRepositoryImpl = null;



    private StaffRoleService(){
        this.staffRoleRepositoryImpl = StaffRoleRepositoryImpl.getRepository();
    }

    public static StaffRoleService getService(){
        if(staffRoleService == null)
            staffRoleService = new StaffRoleService();
        return staffRoleService;
    }

    @Override
    public StaffRole create(StaffRole staffRole) {
        return this.staffRoleRepositoryImpl.create(staffRole);
    }

    @Override
    public StaffRole read(String roleId) {
        return this.staffRoleRepositoryImpl.read(roleId);
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        return this.staffRoleRepositoryImpl.update(staffRole);
    }

    @Override
    public boolean delete(String roleId) {
        return this.staffRoleRepositoryImpl.delete(roleId);
    }

    @Override
    public Set<StaffRole> getAll() {
        return this.staffRoleRepositoryImpl.getAll();
    }
}

