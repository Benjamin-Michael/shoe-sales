package za.ac.cput.service.impl;

import za.ac.cput.entity.StaffRole;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IStaffRoleService extends IService<StaffRole, String> {
    public Set<StaffRole> getAll();
}
