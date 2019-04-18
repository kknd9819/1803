package dao.impl;

import dao.StudentDao;
import model.Student;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public List<Student> findAll() {
        //1、打开数据库连接
        //2、创建预编译语句
        //3、执行语句
        //4、需要对返回的结果做映射  --> 映射到模型上
        //5、关闭连接并返回数据
        List<Student> list = new ArrayList<>();
        Connection con = JdbcUtil.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from student";
        try{
            assert con != null;
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("studentName"));
                student.setAge(rs.getInt("age"));
                student.setTelphone(rs.getString("telphone"));
                list.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt,rs,con);
        }
        return list;
    }

    @Override
    public int save(Student student) {
        Connection con = JdbcUtil.getCon();
        PreparedStatement pstmt = null;
        int i = 0 ;
        String sql = "insert into student (studentName,age,telphone) values (?,?,?)";
        try{
            assert con != null;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,student.getStudentName());
            pstmt.setInt(2,student.getAge());
            pstmt.setString(3,student.getTelphone());
            i = pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt,null,con);
        }
        return i;
    }

    @Override
    public Student findById(int userId) {
        Connection con = JdbcUtil.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            assert con != null;
            String sql = "select * from student where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,userId);
            rs = pstmt.executeQuery();
            rs.next();
            Student student = new Student();
            student.setId(userId);
            student.setAge(rs.getInt("age"));
            student.setStudentName(rs.getString("studentName"));
            student.setTelphone(rs.getString("telphone"));
            return student;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt,rs,con);
        }
        return null;
    }

    @Override
    public int update(Student student) {
        Connection con = JdbcUtil.getCon();
        PreparedStatement pstmt = null;
        try{
            assert con != null;
            String sql = "update student set studentName=?,age=?,telphone=? where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,student.getStudentName());
            pstmt.setInt(2,student.getAge());
            pstmt.setString(3,student.getTelphone());
            pstmt.setInt(4,student.getId());
            return pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt,null,con);
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        Connection con = JdbcUtil.getCon();
        PreparedStatement pstmt = null;
        try{
            assert con != null;
            String sql = "delete from student where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            return pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt,null,con);
        }
        return 0;
    }
}
