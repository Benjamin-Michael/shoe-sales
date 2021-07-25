package za.ac.cput.entity;
/*StaffRole.java
  Entity for staffrole class
  Author: Phindiwe Bambata (217180833)
  Date: 08/06/2021
 */
public class StaffRole {
    private String staffId,roleId, staffRole, roleDescription;

    private StaffRole(StaffRole.Builder builder){
        this.roleId = builder.roleId;
        this.staffRole = builder.staffRole;
        this.roleDescription = builder.roleDescription;

    }


    @Override
    public String toString() {
        return "StaffRole{" +
                "roleId='" + roleId + '\'' +
                ", staffRole='" + staffRole + '\'' +
                ", roleDescription='" + roleDescription +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public static class Builder{
        private String roleId, staffRole, roleDescription;
        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setStaffRole(String staffRole) {
            this.staffRole = staffRole;
            return this;
        }

        public Builder setRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
            return this;
        }


        public StaffRole build(){
            return new StaffRole(this);
        }

        public StaffRole.Builder copy(StaffRole staffRole){
            this.roleId = staffRole.roleId;
            this.staffRole = staffRole.staffRole;
            this.roleDescription = staffRole.roleDescription;

            return this;

        }

    }

}

