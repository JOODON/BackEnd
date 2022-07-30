package Role;

import java.sql.*;

public class Roledao {
    //만들어둔 Role을 가져오겠다
    private static String dburl="jdbc:mysql://localhost:3307/role";
    private static String dbuser="root";
    private static String dbpasswd="kkjjss103@";
    public Role getRole(Integer roleID){
        Role role=null;
        Connection conn=null; //연결을 해주는 개체
        PreparedStatement ps=null; //명령 준비? 을 실행해주는 객체
        ResultSet rs=null; //결과값을 저장

        try {
//          Class.forName("com.mysql.cj.jdbc.Driver");//이렇게 적어주어야됨 //근데 자동으로도 됨 일단 알아만두셈
            conn= DriverManager.getConnection(dburl,dbuser,dbpasswd);//테이블에 접속해주는 부분
            String sql="SELECT role_ID,descriptption FROM role WHERE role_id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,roleID) ;
            rs=ps.executeQuery();//실행 하는 부분
            if (rs.next()) {
                //결과값에 따라 참 거짓을 반환
                int id=rs.getInt(1);
                String des=rs.getString("descriptption");
                role=new Role(id,des);
            }
        }catch (Exception e){
            e.printStackTrace();//
        }
        //반드시 실행되는 부분
        finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return role;
            }
    }
}
