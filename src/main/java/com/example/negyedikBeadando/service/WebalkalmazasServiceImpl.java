package com.example.negyedikBeadando.service;

import com.example.negyedikBeadando.RegistrationAlreadyExistsException;
import com.example.negyedikBeadando.RegistrationNotExistException;
import com.example.negyedikBeadando.dao.BejelentezesDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class WebalkalmazasServiceImpl implements WebalkalmazasService {
    private final BejelentezesDao bejelentezesDao;


    @Override
    public void reg(Regisztracio regisztracio) throws RegistrationAlreadyExistsException {
        Collection<Regisztracio> allReg = getAllReg();
        for (Regisztracio data:allReg){
            if (data.getFelhasznalonev().equals(regisztracio.getFelhasznalonev())){
                throw new RegistrationAlreadyExistsException();
            }
        }
        bejelentezesDao.save(
                com.example.negyedikBeadando.dao.Bejelenkezes.builder()
                        .nev(regisztracio.getNev())
                        .felhasznalonev(regisztracio.getFelhasznalonev())
                        .jelszo(regisztracio.getJelszo())
                        .build()
        );
    }

    @Override
    public Collection<Regisztracio> getAllReg() {
        return bejelentezesDao.readAll().stream().map(
                daoReg -> Regisztracio.builder()
                        .nev(daoReg.getNev())
                        .felhasznalonev(daoReg.getFelhasznalonev())
                        .jelszo(daoReg.getJelszo())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public void bejel(Bejelentkezes bejelentkezes) throws RegistrationNotExistException {
        if (!getAllBej().contains(bejelentkezes)){
                throw  new RegistrationNotExistException();
        }
    }

    @Override
    public Collection<Bejelentkezes> getAllBej() {
        return bejelentezesDao.readAll().stream().map(
                daoBej -> Bejelentkezes.builder()
                            .felhasznalonev(daoBej.getFelhasznalonev())
                            .jelszo(daoBej.getJelszo())
                            .build()
        ).collect(Collectors.toList());
    }
}
