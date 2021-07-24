package za.ac.cput.repository.impl;
/*StaffRepository.java
  Repository for staff class
  Author: Phindiwe Bambata (217180833)
  Date: 24/07/2021
 */

import za.ac.cput.entity.Staff;
import za.ac.cput.repository.IRepository;

import java.util.Set;


public interface StaffRepository extends IRepository<Staff, String> {
    public Set<Staff> getAll();

}

