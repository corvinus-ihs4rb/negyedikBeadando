package com.example.negyedikBeadando.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Bejelenkezes {
    private String nev;
    private String felhasznalonev;
    private String jelszo;
}
