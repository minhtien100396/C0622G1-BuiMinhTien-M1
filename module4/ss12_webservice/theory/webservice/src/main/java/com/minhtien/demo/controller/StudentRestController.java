package com.minhtien.demo.controller;

import com.minhtien.demo.bean.ClassRoom;
import com.minhtien.demo.bean.Student;
import com.minhtien.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
    @Qualifier("studentService")
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getListStudent() {
       try {
           List<Student> students = studentService.findAll();
           if(students.size() == 0) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(students,HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }

    @PostMapping(value = "create")
    //@Valid : validate cho toàn bộ thuộc tính của model
    //@Validated: hỗ trợ validate 1 phần/ nhóm cảu model
    //BindingResult phải luôn luôn nằm ngay  sau model
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student,
                              BindingResult bindingResult
                             ) {
//        new Student().validate(student,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
