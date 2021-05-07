package com.example.negyedikBeadando.service;

import com.example.negyedikBeadando.RegistrationAlreadyExistsException;
import com.example.negyedikBeadando.RegistrationNotExistException;


import java.util.Collection;

public interface WebalkalmazasService {
    void reg(Regisztracio regisztracio) throws RegistrationAlreadyExistsException;
    Collection<Regisztracio> getAllReg();
    void bejel(Bejelentkezes bejelentkezes) throws RegistrationNotExistException;
    Collection<Bejelentkezes> getAllBej();
 }
