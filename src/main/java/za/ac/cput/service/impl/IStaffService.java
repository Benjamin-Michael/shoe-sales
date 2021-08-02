package za.ac.cput.service.impl;

import za.ac.cput.entity.Staff;
import za.ac.cput.service.IService;
import java.util.Set;

public interface  IStaffService extends IService<Staff, String> {

    Set<Staff> getAll();
}
