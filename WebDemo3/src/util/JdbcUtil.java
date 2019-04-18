package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {

    public static Connection getCon(){
        String url = "jdbc:mysql://127.0.0.1:3306/cz1813?useSSL=false";
        String username = "root";
        String password = "Zheng1234";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement pstmt, ResultSet rs ,Connection con){
        try{
            if(pstmt != null){
                pstmt.close();
            }
            if(rs != null){
                rs.close();
            }
            if(con != null){
                con.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
