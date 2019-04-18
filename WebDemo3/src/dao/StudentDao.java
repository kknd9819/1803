package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    int save(Student student);
    Student findById(int userId);
    int update(Student student);
    int deleteById(int id);
}
