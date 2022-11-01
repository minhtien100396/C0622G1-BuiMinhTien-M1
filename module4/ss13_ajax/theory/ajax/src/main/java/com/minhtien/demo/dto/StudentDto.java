package com.minhtien.demo.dto;

import com.minhtien.demo.bean.ClassRoom;
import com.minhtien.demo.utils.annotation.NameConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class StudentDto implements Validator {
    //@Id : khai báo khóa chính
    //Tìm hiểu thêm Custorm GeneratedValue
    //DENTITY: tự động tăng
    private Integer id; //Thuộc tính id
    @NotNull(message = "Name không được để trống (not null)")
    @NotEmpty(message = "Name không được để trống (not empty)")
    @NotBlank(message = "Name không được để trống (not blank)")
    @NameConstraint
    @Column(name = "name")
    private String name; // Thuộc tính name
    // name: tên cột, columnDefinition: kiểu dữ liệu của cột
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date phải đúng định dạng YYYY-mm-DD")
    @Column(name = "birthday", columnDefinition = "DATE")
    private String dateOfBirth;// Thuộc tính date_of_birth
    // 0:Female, 1:Male
    private Integer gender;

    private Double grade;



    private Integer classRoom;

    public Integer getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Integer classRoom) {
        this.classRoom = classRoom;
    }

    public StudentDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if (!studentDto.name.matches("[A-Za-z ]{4,}")) {
            errors.rejectValue("name","name.invalidFormat");
        }
        if (studentDto.grade < 0) {
            errors.rejectValue("grade","grade.min");
        }
    }
}
