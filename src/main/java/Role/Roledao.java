package Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Roledao {
    private static String dburl = "jdbc:mysql://localhost:3307/role";
    private static String dbUser = "root";
    private static String dbpasswd = "kkjjss103@";

    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT descriptption, role_id FROM role order by role_id desc";
        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String description = rs.getString(1);
                    int id = rs.getInt("role_id");
                    Role role = new Role(id, description);
                    list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

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
