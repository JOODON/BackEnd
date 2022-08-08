package Role;

import java.sql.*;

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

            i = ps.executeUpdate();//없데이를 실행
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
    public String getpost(String postname){
        Role1 role1=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(dburl,dbuser,dbpassward);
            String sql = "SELECT name,phonenumber,companyname FROM post WHERE name = ? ";
            ps=conn.prepareStatement(sql);
            ps.setString(1,postname);
            rs= ps.executeQuery();
            if(rs.next()){
                String name=rs.getString(1);
                String phonenumber=rs.getString(2);
                String companyname=rs.getString(3);
                role1=new Role1(name,phonenumber,companyname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return postname;
    }
}
