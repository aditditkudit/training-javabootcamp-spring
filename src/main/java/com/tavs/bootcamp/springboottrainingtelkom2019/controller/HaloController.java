package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import com.tavs.bootcamp.springboottrainingtelkom2019.model.Mahasiswa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HaloController {
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public HaloController(){
        this.daftarMahasiswa.add(new Mahasiswa("Hayayaya", 123123));
        this.daftarMahasiswa.add(new Mahasiswa("H123", 123123));
        this.daftarMahasiswa.add(new Mahasiswa("asdsad", 123123));
        this.daftarMahasiswa.add(new Mahasiswa("asdasd", 123123));
    }


    //Menggunakan protokol Get
    @GetMapping("/halo")
    public String halo(Model model,
                       @ModelAttribute Mahasiswa mahasiswa){
        model.addAttribute("tanggal", new Date());
        model.addAttribute("message", "Kudit gansss");
        model.addAttribute("mahasiswa", mahasiswa);
        model.addAttribute("listMahasiswa", daftarMahasiswa);
        return "/belajar-html";
    }

//    Menggunakan method post
    @PostMapping("/haloPost")
    public String requestPost(
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) Integer umur){
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
