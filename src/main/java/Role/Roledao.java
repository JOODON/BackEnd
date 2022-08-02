package Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Roledao {
    private static String dburl = "jdbc:mysql://localhost:3307/role";
    private static String dbUser = "root";
    private static String dbpasswd = "kkjjss103@";
    public int addRole(Role role){
        int insertCount=0;
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
            String sql="INSERT INTO role (role_ID,descriptption) VALUES (?,?)";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,role.getRoleId());
            ps.setString(2,role.getDescription());

            insertCount = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ps != null){
                try {
                    ps.close();
                }catch (Exception e){

                }
            }
            if (conn !=null){
                try {
                    conn.close();
                }catch (Exception e){

                }
            }
            return insertCount;
        }
    }
    public Role getRole(Integer roleId) {
        Role role = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
            String sql = "SELECT descriptption,role_id FROM role WHERE role_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String descriptption = rs.getString(1);
                int id = rs.getInt(2);
                role = new Role(id,descriptption);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

        return role;
    }
}