package com.example.negyedikBeadando.controller;


import com.example.negyedikBeadando.RegistrationAlreadyExistsException;
import com.example.negyedikBeadando.RegistrationNotExistException;
import com.example.negyedikBeadando.service.Bejelentkezes;
import com.example.negyedikBeadando.service.Regisztracio;
import com.example.negyedikBeadando.service.WebalkalmazasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RequestMapping("/negyedik")
@RestController
@RequiredArgsConstructor
public class MainController {

    private final WebalkalmazasService webalkalmazasService;

    @PostMapping(path = "/bej")
    public void bejelentkezes( @RequestBody BejelDto bejelDto)
    {
        try {
            webalkalmazasService.bejel(
                    Bejelentkezes.builder()
                            .felhasznalonev(bejelDto.getFelhasznalonev())
                            .jelszo(String.valueOf(bejelDto.getJelszo().hashCode()))
                            .build()
            );
        }

        catch (RegistrationNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    "Nem létezik ilyen regisztráció!"
            );
        }
    }
    @PostMapping(path = "/reg")
    public void regisztracio(@Valid @RequestBody RegDto regDto){
        try {
            webalkalmazasService.reg(
                    Regisztracio.builder()
                            .nev(regDto.getNev())
                            .felhasznalonev(regDto.getFelhasznalonev())
                            .jelszo(String.valueOf((regDto.getJelszo()).hashCode()))
                            .build()
            );
        } catch (RegistrationAlreadyExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    "Nem érvényes regisztráció!"
            );
        }
    }
}
