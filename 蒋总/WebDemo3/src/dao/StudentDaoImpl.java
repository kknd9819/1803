package dao;

import Util.JdbcUtil;
import dao.StudentDao;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

  //查
    @Override
    public List <Student> findAll() {
        //1.打开数据库连接
        //2.创建预编译语句
        //3.执行语句
        //4.需要对返回的结果做映射 ——>映射到模型上
        //5.关闭连接并返回数据
        List<Student> list = new ArrayList <> ();
        Connection con = JdbcUtil.getCon ();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from student";
        try {
            pstmt = con.prepareStatement ( sql );
            rs = pstmt.executeQuery ();
            while (rs.next ()){
                Student student = new Student ();
                student.setId ( rs.getInt ( "id" ) );
                student.setStudent_name ( rs.getString ( "student_name" ) );
                student.setAge ( rs.getInt ( "age" ) );
                student.setSex ( rs.getString ( "sex" ) );
                student.setTlephone ( rs.getString ( "tlephone" ) );
                list.add ( student );
            }
        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            JdbcUtil.colse (pstmt,rs,con);
        }
        return list;
    }
    //增
    @Override
    public int save(Student student) {
        Connection con = JdbcUtil.getCon ();
        PreparedStatement pstmt = null;
        int i = 0;
        String sql = "insert into student (student_name,age,sex,tlephone) values (?,?,?,?)";
        try {
            pstmt = con.prepareStatement ( sql );
            pstmt.setString ( 1,student.getStudent_name () );
            pstmt.setInt ( 2,student.getAge () );
            pstmt.setString ( 3,student.getSex () );
            pstmt.setString ( 4,student.getTlephone () );

             i = pstmt.executeUpdate ();

        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            JdbcUtil.colse ( pstmt,null,con );
        }
        return i;
    }


}
