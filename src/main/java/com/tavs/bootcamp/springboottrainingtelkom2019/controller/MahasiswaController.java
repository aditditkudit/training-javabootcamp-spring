package com.tavs.bootcamp.springboottrainingtelkom2019.controller;

import com.tavs.bootcamp.springboottrainingtelkom2019.MahasiswaRepository;
import com.tavs.bootcamp.springboottrainingtelkom2019.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MahasiswaController {

    private MahasiswaRepository repo;

    @Autowired
    public MahasiswaController(MahasiswaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/mahasiswa")
    public String index(Model model,
                        @ModelAttribute Mahasiswa mahasiswa){
        model.addAttribute("mahasiswa", mahasiswa);
        Iterable<Mahasiswa> all = repo.findAll();
        model.addAttribute("listMahasiswa", all);
        return "pages/mahasiswa_list";
    }

    @RequestMapping("/mahasiswa/addMahasiswa")
    public String addMahasiswaForm(Model model,
                                   @ModelAttribute Mahasiswa mahasiswa){
        model.addAttribute("mahasiswa", mahasiswa);
        return "pages/mahasiswa_add";
    }


    @PostMapping("/mahasiswa/addMahasiswaP")
    public String submitMahasiswaForm(
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) Integer umur) {
        repo.save(new Mahasiswa(null, nama, umur));
        System.out.println("Nama dari request post: " + nama + ", Umur dari request post: " + umur);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/mahasiswa/editMahasiswa/{id}")
    public String showUpdateMahasiswaForm(@PathVariable("id") int id, Model model){
        Mahasiswa mahasiswa = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid mahasiswa Id: " + id));
        model.addAttribute("mahasiswa", mahasiswa);
        return "pages/mahasiswa_update";
    }

    @PostMapping("/mahasiswa/editMahasiswa/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Mahasiswa mahasiswa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            mahasiswa.setId(id);
            return "pages/kelas_update";
        }
        repo.save(mahasiswa);
        model.addAttribute("mahasiswa", repo.findAll());
        return "redirect:/mahasiswa";
    }

    @GetMapping("/mahasiswa/deleteMahasiswa/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Mahasiswa mahasiswa = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repo.delete(mahasiswa);
        model.addAttribute("users", repo.findAll());
        return "redirect:/mahasiswa";
    }
}
