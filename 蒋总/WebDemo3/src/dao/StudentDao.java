package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    //查询
    List<Student> findAll();
    //增
    int save(Student student);
    //删
}
