package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/student/v1")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;

//    Lấy tài nguyên
    @GetMapping
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);


    }

    //Thêm tài nguyên
    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity(HttpStatus.OK);
    }

//    Update tài nguyên
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer id,
                                                 @RequestBody StudentDto studentDto){
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentStudent.setName(studentDto.getName());
        currentStudent.setGender(studentDto.getGender());
//        BeanUtils.copyProperties(studentDto,currentStudent);
        studentService.save(currentStudent);
        return new ResponseEntity<Student>(currentStudent,HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable(value = "id") Integer id,
                                                 @RequestBody Map<Object, Object> fields){
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//


        for(Map.Entry<Object, Object> entry : fields.entrySet()) {
            Field field = ReflectionUtils.findField(Student.class, (String)entry.getKey());
            field.setAccessible(true);
            ReflectionUtils.setField(field, currentStudent, entry.getValue());
        }

        //duyet lamda
//        fields.forEach((key, value)->{
//            Field field = ReflectionUtils.findField(Student.class, (String)key);
//            field.setAccessible(true);
//            ReflectionUtils.setField(field, currentStudent, value);
//        });
        studentService.save(currentStudent);
        return new ResponseEntity<Student>(currentStudent,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable(value = "id") Integer id){
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.delete(currentStudent);
        return new ResponseEntity(HttpStatus.OK);
    }

}
