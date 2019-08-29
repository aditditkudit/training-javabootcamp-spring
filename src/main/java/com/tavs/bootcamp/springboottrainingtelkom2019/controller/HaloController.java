package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HaloController {

    //Menggunakan protokol Get
    @GetMapping("/halo")
    public String halo(Model model){
        model.addAttribute("tanggal", new Date());
        model.addAttribute("message", "Kudit gansss");
        return "/belajar-html";
    }

}
