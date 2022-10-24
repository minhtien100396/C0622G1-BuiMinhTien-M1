package com.minhtien.exercise_2.controller;

import com.minhtien.exercise_2.dto.MusicDto;
import com.minhtien.exercise_2.model.Music;
import com.minhtien.exercise_2.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @GetMapping
    public String displayListSong(@RequestParam(value = "page",defaultValue = "0") int page,
                                  Model model){
        model.addAttribute("musicList",musicService.displayAll(PageRequest.of(page,5)));
        return "/music/list";
    }
    @GetMapping("/create")
    public String displayFormCreate(Model model){
        model.addAttribute("musicDto", new MusicDto());
        return "/music/create";
    }
    @PostMapping("/create")
    public String addMusic(@Validated @ModelAttribute("musicDto") MusicDto musicDto,
                            BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return"/music/create";
        }else{
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            model.addAttribute("music",music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Add new music successfully!");
            return "redirect:/";
        }
    }
    @GetMapping("/{id}/edit")
    public String displayFormEdit(@PathVariable(value = "id") int id,
                           Model model){
        model.addAttribute("musicDto",musicService.findById(id));
        return "/music/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("musicDto") MusicDto musicDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return"/music/edit";
        }else{
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            model.addAttribute("music",music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Edit new music successfully!");
            return "redirect:/";
        }
    }
}
