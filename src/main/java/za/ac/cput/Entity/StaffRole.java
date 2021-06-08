package za.ac.cput.Entity;

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

    public static class Builder{
        private String roleId, staffRole, roleDescription;
        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public void setStaffRole(String staffRole) {
            this.staffRole = staffRole;
        }

        public void setRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
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

