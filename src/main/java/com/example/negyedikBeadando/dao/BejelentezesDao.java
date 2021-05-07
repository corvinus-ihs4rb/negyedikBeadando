package com.example.negyedikBeadando.dao;

import java.util.Collection;

public interface BejelentezesDao {
    Collection<Bejelenkezes> readAll();
    void save(Bejelenkezes bejelenkezes);
}
