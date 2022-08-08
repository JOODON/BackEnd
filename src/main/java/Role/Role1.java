package Role;

public class Role1 {
    private String name;
    private String phonenumber;
    private String companyname;

    public Role1(String name, String phonenumber, String companyname) {
        super();
        this.name=name;
        this.phonenumber=phonenumber;
        this.companyname=companyname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "Role1{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", companyname='" + companyname + '\'' +
                '}';
    }

}
