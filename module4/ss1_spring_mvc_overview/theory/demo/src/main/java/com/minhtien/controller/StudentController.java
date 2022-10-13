package com.minhtien.controller;

import com.minhtien.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Với value thì chúng ta  thay tên bean từ studentController -> student
@Controller(value = "student")
public class StudentController {
    // Muốn triển khai theo lớp nào thì đặt tên trong phần @
    @Qualifier("textService")
    @Autowired
    private IStudentService studentService;
    // tương đương với câu lệnh private IStudentService studentService = new StudentService();
    //Nếu sử dụng phương thức get thì @GetMapping
//    value : chính là đường dẫn trên thanh URL
    @GetMapping(value = "/list")
    public String getListStudent(Model model) {
//        Dùng model để gửi dữ liêu sang view
        model.addAttribute("studentList", studentService.findAll());
        //list: chính là đi đến file list.jsp
        return "list";
    }
}
