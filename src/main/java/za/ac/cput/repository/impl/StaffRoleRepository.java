package za.ac.cput.repository.impl;
/*StaffRoleRepository.java
  Repository for staffRole class
  Author: Phindiwe Bambata (217180833)
  Date: 24/07/2021
 */

import za.ac.cput.entity.StaffRole;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface StaffRoleRepository extends IRepository<StaffRole, String> {
     public Set<StaffRole> getAll();

        }

