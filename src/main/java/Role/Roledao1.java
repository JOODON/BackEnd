package Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Roledao1 {
    public static String dburl="jdbc:mysql://localhost:3307/post";
    public static String dbuser="root";
    public static String dbpassward="kkjjss103@";

    public int addpost(Role1 role1){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(dburl,dbuser,dbpassward);
            String sql="INSERT INTO POST (name,phonenumber,companyname) VALUES (?,?,?)";
            ps=conn.prepareStatement(sql);

            ps.setString(1,role1.getName());
            ps.setString(2,role1.getPhonenumber());
            ps.setString(3,role1.getCompanyname());

            i = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (ps==null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (conn==null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return i;
    }
}
