package com.minhtien.demo.controller;

import com.minhtien.demo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class StudentTalkController {
    @GetMapping("/talk")
    public String getTalkList(@SessionAttribute(name = "studentTalkList") List<Student> students,
                              Model model){
        model.addAttribute("students",students);
        return "student/list_talk";
    }
}
