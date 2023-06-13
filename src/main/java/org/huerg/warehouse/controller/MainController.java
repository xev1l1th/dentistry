package org.huerg.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class MainController {

    @GetMapping("")
    public String get() {
        return "main";
    }

    @GetMapping("/")
    public String gettt() {
        return "main";
    }

    @GetMapping("/js/**")
    public String getA() {
        return "redirect:/";
    }

    @GetMapping("css/**")
    public String getC() {
        return "redirect:/";
    }
    @PostMapping("css/**")
    public String getccc() {
        return "redirect:/";
    }
}
