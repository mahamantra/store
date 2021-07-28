package com.example.store.service;

import com.example.store.model.Toy;
import com.example.store.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {

    private final ToyRepository toyRepository;

    @Autowired
    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public Toy findById(Long id) {
        return toyRepository.getById(id);
    }

    public List<Toy> findAll() {
        return toyRepository.findAll();
    }

    public Toy saveToy(Toy toy) {
        return toyRepository.save(toy);
    }

    public void deleteById(Long id) {
        toyRepository.deleteById(id);
    }
}
