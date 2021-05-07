package com.example.negyedikBeadando.service;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bejelentkezes {

    private String felhasznalonev;
    private String jelszo;

}
