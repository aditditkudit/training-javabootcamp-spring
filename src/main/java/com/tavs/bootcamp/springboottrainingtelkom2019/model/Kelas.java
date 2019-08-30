package com.tavs.bootcamp.springboottrainingtelkom2019.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "kelas")

public class Kelas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String kodekelas;
    private String namakelas;


}
