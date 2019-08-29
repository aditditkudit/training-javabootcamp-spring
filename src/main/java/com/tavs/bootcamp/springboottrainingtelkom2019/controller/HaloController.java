package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HaloController {

    //Menggunakan protokol Get
    @GetMapping("/halo")
    public String halo(Model model,
                       @RequestParam(required = false) String nama, //Menggunakan Request parameter
                       @RequestParam(required = false) Integer umur){
        model.addAttribute("tanggal", new Date());
        model.addAttribute("message", "Kudit gansss");
        model.addAttribute("nama", nama); // Memasukkan request parameter pada variable name di html
        model.addAttribute("umur", umur); // Memasukkan request parameter pada variable umur di html
        System.out.println("Nama dari request: " + nama + ", umur dari request: "+ umur);
        return "/belajar-html";
    }

}
