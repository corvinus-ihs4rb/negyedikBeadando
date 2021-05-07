package com.example.negyedikBeadando.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class RegEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nev;
    @Column
    private String felhasznalonev;
    @Column
    private String jelszo;

}
