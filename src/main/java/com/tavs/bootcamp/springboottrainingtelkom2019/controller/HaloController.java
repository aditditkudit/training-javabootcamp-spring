package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HaloController {
    @GetMapping("/halo")
    public String halo(){
        return "/belajar-html";
    }

}
