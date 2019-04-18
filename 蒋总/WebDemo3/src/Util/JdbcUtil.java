package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
    public static Connection getCon() {
        String url = "jdbc:mysql://localhost:3306/cztt1813?useSSL=false";
        String username = "root";
        String password = "root";
        try {
            Class.forName ( "com.mysql.jdbc.Driver" );
            return DriverManager.getConnection ( url, username, password );

        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    public static void colse(PreparedStatement pstmt, ResultSet rs, Connection con) {
        try {
            if (pstmt != null) {
                pstmt.close ();
            }
            if (rs != null) {
                rs.close ();
            }
            if (con != null) {
                con.close ();
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
