package com.example.negyedikBeadando.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
@Slf4j
@RequiredArgsConstructor
public class BejelentezesDaoImpl implements BejelentezesDao{
    private final BejelentkezesRepository bejelentkezesRepository;

    @Override
    public Collection<Bejelenkezes> readAll() {
        return StreamSupport.stream(bejelentkezesRepository.findAll().spliterator(), false)
                .map(entity -> Bejelenkezes.builder()
                    .felhasznalonev(entity.getFelhasznalonev())
                    .nev(entity.getNev())
                    .jelszo(entity.getJelszo())
                    .build())
                .collect(Collectors.toList());

    }

    @Override
    public void save(Bejelenkezes bejelenkezes) {
        RegEntity entity =
                new RegEntity();
        entity.setFelhasznalonev(bejelenkezes.getFelhasznalonev());
        entity.setNev(bejelenkezes.getNev());
        entity.setJelszo(bejelenkezes.getJelszo());
        bejelentkezesRepository.save(entity);
    }
}
