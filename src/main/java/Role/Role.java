package Role;

public class Role {
    private Integer roleID;
    private String description;

    public Role(int id, String des) {
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "role{" +
                "roleID=" + roleID +
                ", description='" + description + '\'' +
                '}';
    }
}
