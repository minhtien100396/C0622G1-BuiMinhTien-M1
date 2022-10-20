package com.minhtien.bean;

import javax.persistence.*;

// @Entity(name = "student") : Tên của Table mà chúng ta Mapping
@Entity(name = "student")
public class Student {
    //@Id : khai báo khóa chính
    //Tìm hiểu thêm Custorm GeneratedValue
    //DENTITY: tự động tăng
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Thuộc tính id
    @Column(name = "name")
    private String name; // Thuộc tính name
    // name: tên cột, columnDefinition: kiểu dữ liệu của cột
    @Column(name = "birthday",columnDefinition = "DATE")
    private String dateOfBirth;// Thuộc tính date_of_birth
    // 0:Female, 1:Male
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "point")
    private Double grade;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
