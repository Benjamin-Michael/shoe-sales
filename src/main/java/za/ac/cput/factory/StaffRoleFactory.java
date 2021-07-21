package za.ac.cput.factory;
/*StaffRoleFactory.java
  Factory for staffrole class
  Author: Phindiwe Bambata (217180833)
  Date: 09/06/2021
 */
import za.ac.cput.entity.StaffRole;
import za.ac.cput.util.GenericHelper;

public class StaffRoleFactory {
    public static StaffRole createStaffRole(String staffRole, String roleDescription) {

        String roleId = GenericHelper.generateId();

        StaffRole staffrole = new StaffRole.Builder()
                .setRoleId(roleId)
                .setStaffRole(staffRole)
                .setRoleDescription(roleDescription)
                .build();

        return staffrole;
    }
}
