package com.minhtien.bean;

import javax.persistence.*;
import java.util.List;

@Entity(name = "class")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String nameClass;

    //mappedBy phải cùng tên với thuộc tính bên class nhiều.

    // Trường hợp mà không dùng đến List<Student> như chức năng hiển thị danh sách học
    // sinh của 1 lớp + Trường hợp không sử dụng casade -> không nên khai báo @OneTomMany

//    @OneToMany(mappedBy = "classRoom")
//    private List<Student> studentList;
//
//    public List<Student> getStudentList() {
//        return studentList;
//    }
//
//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }

    public ClassRoom() {
    }

    public ClassRoom(Integer id, String nameClass) {
        this.id = id;
        this.nameClass = nameClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
