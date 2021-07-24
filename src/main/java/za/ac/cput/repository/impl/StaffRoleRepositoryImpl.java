package za.ac.cput.repository.impl;
/*StaffRoleRepositoryImpl.java
  Repository implementation for staff class
  Author: Phindiwe Bambata (217180833)
  Date: 24/07/2021
 */

import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;

import java.util.HashSet;
import java.util.Set;
public class StaffRoleRepositoryImpl implements StaffRoleRepository{
    private static StaffRoleRepository repository = null;
    private Set<StaffRole> staffRoleDB;
    private StaffRoleRepositoryImpl() { this.staffRoleDB = new HashSet<>();}

    public static StaffRoleRepository getRepository() {
        if(repository == null) repository = new StaffRoleRepositoryImpl();
        return repository;
    }

    @Override
    public StaffRole create(StaffRole staffRole) {
        this.staffRoleDB.add(staffRole);
        return staffRole;
    }

    @Override
    public StaffRole read(final String roleId) {
        for (StaffRole staffRole : this.staffRoleDB) {
            if(staffRole.getRoleId().equalsIgnoreCase(roleId)) return staffRole;
        }
        return null;
    }

    @Override
    public StaffRole update(StaffRole staffRole) {
        StaffRole role = read(staffRole.getRoleId());
        if(role != null) {
            staffRoleDB.remove(role);
            staffRoleDB.add(staffRole);
            return staffRole;
        }
        return null;
    }

    @Override
    public boolean delete(String roleId) {
        StaffRole staffRole = read(roleId);
        if(staffRole != null) {
            this.staffRoleDB.remove(staffRole);
            return true;
        }
        return false;
    }

    @Override
    public Set<StaffRole> getAll() {
        return this.staffRoleDB;
    }
}

