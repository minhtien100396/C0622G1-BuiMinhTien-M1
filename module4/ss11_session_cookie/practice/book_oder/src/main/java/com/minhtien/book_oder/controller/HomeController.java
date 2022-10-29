package com.minhtien.book_oder.controller;

import com.minhtien.book_oder.model.Book;
import com.minhtien.book_oder.model.Oder;
import com.minhtien.book_oder.service.IBookServicce;
import com.minhtien.book_oder.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/book")
public class HomeController {
    @Autowired
    private IBookServicce bookServicce;
    @Autowired
    private IOderService oderService;

    @GetMapping("/home")
    public String displayHome(@CookieValue(value = "cookieCount", defaultValue = "0") int cookieCcount,
                              HttpServletResponse response,
                              @RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Cookie cookie = new Cookie("cookieCount", String.valueOf(cookieCcount+1));
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        model.addAttribute("cookie",cookie);
        model.addAttribute("bookPage", bookServicce.findAll(PageRequest.of(page, 5)));
        return "/book/home";
    }

    @GetMapping("/{id}/oder")
    public String oder(@PathVariable(value = "id") int id,
                       RedirectAttributes redirectAttributes) throws Exception {
        Book book = bookServicce.findById(id);
        if (book.getCount() == 0) {
            throw new Exception();
        }
        book.setCount(book.getCount() - 1);
        Oder oder = new Oder();
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        if (oderService.findByCode(code) == null) {
            oder.setCode(code);
        } else {
            throw new Exception();
        }
        String date = String.valueOf(LocalDate.now());
        oder.setDate(date);
        oderService.save(oder);
        List<Oder> oderList = book.getOrderList();
        oderList.add(oder);
        book.setOrderList(oderList);
        bookServicce.save(book);
        redirectAttributes.addFlashAttribute("message", "Oder book successfully! And Code: " + oder.getCode());
        return "redirect:/book/home";
    }


    @GetMapping("/return")
    public String pay(@RequestParam(value = "code") int code,
                      RedirectAttributes redirect) throws Exception {
        Book book = bookServicce.findByCode(code);
        if (book == null) {
            throw new Exception();
        } else {
            book.setCount(book.getCount() + 1);
            bookServicce.save(book);
            Oder oder = oderService.findByCode(code);
            oder.setCode(0);
            oderService.save(oder);
            redirect.addFlashAttribute("message", "Give book back successfully! ");
        }
        return "redirect:/book/home";

    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "/book/error";
    }
}
