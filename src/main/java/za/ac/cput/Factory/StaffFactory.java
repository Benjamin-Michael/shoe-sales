package za.ac.cput.Factory;
/*StaffFactory.java
  Factory for staff class
  Author: Phindiwe Bambata (217180833)
  Date: 09/06/2021
 */
import za.ac.cput.Entity.Staff;
import za.ac.cput.Util.GenericHelper;

public class StaffFactory {
    public static Staff createStaff(String roleId, String firstName, String lastName) {

        String staffId = GenericHelper.generateId();

        Staff staff = new Staff.Builder()
                .setStaffId(staffId)
                .setRoleId(roleId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        return staff;
    }
}
