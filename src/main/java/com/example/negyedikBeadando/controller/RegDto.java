package com.example.negyedikBeadando.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class RegDto {

    @NotNull(message = "Nem lehet üres!")
    private String nev;

    @NotNull(message = "Nem lehet üres!")
    @Size(min = 6)
    private String felhasznalonev;

    @NotNull(message = "Nem lehet üres!")
    @Size(min = 8)
    @Pattern(regexp = "([a-zA-Z]+[0-9]+)")
    private String jelszo;



}
