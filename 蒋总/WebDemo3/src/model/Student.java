package model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -8950945688057768215L;

    private Integer id;
    private String student_name;
    private Integer age;
    private String sex;
    private String tlephone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTlephone() {
        return tlephone;
    }

    public void setTlephone(String tlephone) {
        this.tlephone = tlephone;
    }
}
