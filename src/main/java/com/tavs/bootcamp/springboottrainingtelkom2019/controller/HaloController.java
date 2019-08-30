package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import com.tavs.bootcamp.springboottrainingtelkom2019.MahasiswaRepository;
import com.tavs.bootcamp.springboottrainingtelkom2019.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HaloController {
    @Autowired
    private MahasiswaRepository repo;


    //Menggunakan protokol Get
    @GetMapping("/halo")
    public String halo(Model model,
                       @ModelAttribute Mahasiswa mahasiswa){
        model.addAttribute("tanggal", new Date());
        model.addAttribute("message", "Kudit gansss");
        model.addAttribute("mahasiswa", mahasiswa);
        Iterable<Mahasiswa> all = repo.findAll();
        model.addAttribute("listMahasiswa", all);
        return "/belajar-html";
    }

//    Menggunakan method post
    @PostMapping("/haloPost")
    public String requestPost(
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) Integer umur){
        repo.save(new Mahasiswa(null, nama, umur));
        System.out.println("Nama dari request post: " + nama +", Umur dari request post: " + umur);
        return "redirect:/halo";
    }
//    Menggunakan method Get
    @GetMapping("/haloPost")
    public String requestGet(
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) Integer umur){
        System.out.println("Nama dari request get: " + nama +", Umur dari request get: " + umur);
        return "redirect:/halo";
    }
}
