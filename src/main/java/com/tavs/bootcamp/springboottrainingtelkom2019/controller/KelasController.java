package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import com.tavs.bootcamp.springboottrainingtelkom2019.KelasRepository;
import com.tavs.bootcamp.springboottrainingtelkom2019.model.Kelas;
import com.tavs.bootcamp.springboottrainingtelkom2019.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class KelasController {

    private KelasRepository kelasRepo;

    @Autowired
    public KelasController(KelasRepository kelasRepo) {
        this.kelasRepo = kelasRepo;
    }

    @GetMapping("/kelas")
    public String index(Model model, @ModelAttribute Kelas kelas){
        model.addAttribute("kelas", kelas);
        Iterable<Kelas> all = kelasRepo.findAll();
        model.addAttribute("listKelas", all);
        return "pages/kelas_list";
    }

    @RequestMapping("/kelas/addKelas")
    public String addKelasForm(Model model,
                               @ModelAttribute Kelas kelas){
        model.addAttribute("kelas", kelas);
        return "pages/kelas_add";
    }

    @PostMapping("/kelas/addKelasP")
    public String submitKelasForm(
            @RequestParam(required = false) String kodekelas,
            @RequestParam(required = false) String namakelas) {
        kelasRepo.save(new Kelas(null, kodekelas, namakelas));
        System.out.println("Kode Kelas dari request post: " + kodekelas + ", namaKelas dari request post: " + namakelas);
        return "redirect:/kelas";
    }

    @GetMapping("/kelas/editKelas/{id}")
    public String showUpdateMahasiswaForm(@PathVariable("id") int id, Model model){
        Kelas kelas = kelasRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Kelas Id: " + id));
        model.addAttribute("kelas", kelas);
        return "pages/kelas_update";
    }

    @PostMapping("/kelas/editKelas/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Kelas kelas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            kelas.setId(id);
            return "pages/kelas_update";
        }
        kelasRepo.save(kelas);
        model.addAttribute("kelas", kelasRepo.findAll());
        return "redirect:/kelas";
    }

    @GetMapping("/kelas/deleteKelas/{id}")
    public String deleteKelas(@PathVariable("id") int id, Model model) {
        Kelas kelas = kelasRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        kelasRepo.delete(kelas);
        model.addAttribute("kelas", kelasRepo.findAll());
        return "redirect:/kelas";
    }


}
