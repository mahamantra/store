package com.example.store.service;

import com.example.store.model.Toy;

import java.util.List;

public interface ToyService {

    Toy findById(Long id);

    List<Toy> findAll();

    Toy saveToy(Toy toy);

    void deleteById(Long id);

    boolean update(Toy toy,long id);
}
