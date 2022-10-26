package com.minhtien.controller;

import com.minhtien.bean.Student;
import com.minhtien.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// Với value thì chúng ta  thay tên bean từ studentController -> student
@Controller
public class StudentController {
    // Muốn triển khai theo lớp nào thì đặt tên trong phần @
    @Qualifier("studentService")
    @Autowired
    private IStudentService studentService;
    // tương đương với câu lệnh private IStudentService studentService = new StudentService();
    //Nếu sử dụng phương thức get thì @GetMapping
//    value : chính là đường dẫn trên thanh URL
    @GetMapping(value = "list")
    public String getListStudent(Model model) {
//        Dùng model để gửi dữ liêu sang view
        model.addAttribute("studentList", studentService.findAll());
        //list: chính là đi đến file list.jsp
        return "list";
    }

    //Sử dụng Model
//    @GetMapping(value = "detail/{id}")
//    public String getDetailStudentByPathVariable(@PathVariable(value = "id") int idKey, Model model) {
//        Student student = studentService.findById(idKey);
//        model.addAttribute("student",student);
//        return "detail";
//    }

    //Sử dụng ModelAndView
//    Khi trả về 1 view kèm theo 1  đối tượng cho JSP thì ta sử dụng ModelAndView code sẽ gọn hơn
    @GetMapping(value = "detail/{id}")
    public ModelAndView getDetailStudentByPathVariable(@PathVariable(value = "id") int idKey) {
        Student student = studentService.findById(idKey);
        return  new ModelAndView("detail","student",student);
    }
//    @GetMapping(value = "detail")
//    public String getDetailStudentByRequestParam(@RequestParam(value = "id") int idKey){
//        System.out.println(idKey);
//        return "detail";
//    }

    @GetMapping(value = "create")
    public String getPageCreateStudent(){
        return "create";
    }
    @PostMapping(value = "/create")
    public String saveStudent(@RequestParam("name") String name, @RequestParam("dateOfBirth") String dateOfBirth, RedirectAttributes redirectAttributes) {
        studentService.save(name, dateOfBirth);
        redirectAttributes.addFlashAttribute("msg","Thêm thành công");
        return "redirect:/list";
    }
}