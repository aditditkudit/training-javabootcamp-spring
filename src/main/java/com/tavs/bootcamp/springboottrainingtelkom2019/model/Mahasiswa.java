package com.tavs.bootcamp.springboottrainingtelkom2019.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data


public class Mahasiswa {

    private String nama;
    private Integer umur;

    public Mahasiswa(String nama, Integer umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public Mahasiswa() {
    }

}