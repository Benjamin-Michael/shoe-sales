package za.ac.cput.repository.impl;

import za.ac.cput.entity.StaffRole;

import java.util.HashSet;
import java.util.Set;

public class StaffRoleRepositoryImpl implements StaffRoleRepository {

    private static StaffRoleRepositoryImpl repository = null;
    private Set<StaffRole> staffRoleDB = null;

    private StaffRoleRepositoryImpl() {
        staffRoleDB = new HashSet<StaffRole>();
    }

    public static StaffRoleRepositoryImpl getRepository(){
        if(repository == null)
            repository = new StaffRoleRepositoryImpl();
        return repository;
    }

    @Override
    public StaffRole create(StaffRole staffRole) {
        boolean success = this.staffRoleDB.add(staffRole);
        if(!success)
            return null;

        return staffRole;
    }

    @Override
    public StaffRole read(String  roleId) {

        for (StaffRole staffRole : this.staffRoleDB) {
            if (staffRole.getRoleId().equalsIgnoreCase(roleId))
                return staffRole;
        }

        return null;
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        StaffRole preUpdate = read(staffRole.getRoleId());

        if (preUpdate != null) {
            this.staffRoleDB.remove(preUpdate);
            this.staffRoleDB.add(staffRole);
            return staffRole;
        }

        return null;
    }

    @Override
    public boolean delete(String roleId) {
        StaffRole staffRoleToDelete = read(roleId);

        if (staffRoleToDelete != null) {
            this.staffRoleDB.remove(staffRoleToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<StaffRole> getAll() {
        return staffRoleDB;
    }
}

