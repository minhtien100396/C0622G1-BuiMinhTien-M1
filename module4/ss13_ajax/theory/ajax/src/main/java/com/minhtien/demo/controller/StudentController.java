package com.minhtien.demo.controller;

import com.minhtien.demo.bean.ClassRoom;
import com.minhtien.demo.bean.Student;
import com.minhtien.demo.service.IClassService;
import com.minhtien.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes("studentTalkList")
// Với value thì chúng ta  thay tên bean từ studentController -> student
@Controller
public class StudentController {
    // Muốn triển khai theo lớp nào thì đặt tên trong phần @
    @Qualifier("studentService")
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

    @ModelAttribute("studentTalkList")
    public List<Student> createStudentTalkList() {
        return new ArrayList<>();
    }

    @GetMapping("/addTalk/{id}")
    public String addTalkList(@PathVariable("id") int id,
                              @ModelAttribute(name = "studentTalkList") List<Student> students,
                              RedirectAttributes redirectAttributes) {
        Student student = studentService.findById(id);
        students.add(student);
        redirectAttributes.addFlashAttribute("msg","Add Talk List sucessfuly");
        return "redirect:/list";
    }

    // tương đương với câu lệnh private IStudentService studentService = new StudentService();
    //Nếu sử dụng phương thức get thì @GetMapping
//    value : chính là đường dẫn trên thanh URL
    @GetMapping(value = "/list")
    public String getListStudent(Model model) {
//        Dùng model để gửi dữ liêu sang view
        model.addAttribute("studentList", studentService.findAll());
        //list: chính là đi đến file list.jsp
        return "/student/list";
    }

    //    defaultValue sẽ giúp ta chọn ra giá trị mặc định nếu không có giá trị đó khi gửi lên server
    @GetMapping("/list-page")
    public String getListStudentPage(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        Page<Student> studentPage = studentService.findAll(PageRequest.of(page, 5, sort));
        model.addAttribute("studentPage", studentPage);
        return "student/list_page";
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
    @GetMapping(value = "/{id}/detail")
    public ModelAndView getDetailStudentByPathVariable(@PathVariable(value = "id") int idKey) throws Exception {
        Student student = studentService.findById(idKey);
        if (student == null) {
            throw new Exception();
        }
        return new ModelAndView("student/detail", "student", student);
    }
//    @GetMapping(value = "detail")
//    public String getDetailStudentByRequestParam(@RequestParam(value = "id") int idKey){
//        System.out.println(idKey);
//        return "detail";
//    }

    @GetMapping(value = "create")
    public String getPageCreateStudent(Model model) {
        List<ClassRoom> classRooms = classService.findAll();
        model.addAttribute("classRooms", classRooms);
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping(value = "create")
    //@Valid : validate cho toàn bộ thuộc tính của model
    //@Validated: hỗ trợ validate 1 phần/ nhóm cảu model
    //BindingResult phải luôn luôn nằm ngay  sau model
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes,
                              HttpServletResponse response,
                              @CookieValue(value = "cookieCount", defaultValue = "0") int cookieCount) {
//        new Student().validate(student,bindingResult);
        if (bindingResult.hasErrors()) {
            List<ClassRoom> classRooms = classService.findAll();
            model.addAttribute("classRooms", classRooms);
            return "student/create";
        }
        studentService.save(student);
        Cookie cookie = new Cookie("cookieCount", String.valueOf(cookieCount + 1));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        redirectAttributes.addFlashAttribute("msg", "Thêm thành công");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "searchName", defaultValue = "") String searchName, Model model) {
        List<Student> studentList = studentService.searchByName(searchName);
        model.addAttribute("studentList", studentList);
        return "student/list";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/student/error_student";
    }
}
