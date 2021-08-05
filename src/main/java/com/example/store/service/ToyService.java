package com.example.store.service;

import com.example.store.model.Toy;
import com.example.store.model.dto.ToyDto;
import com.example.store.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToyService {

    private final ToyRepository toyRepository;

    public Toy findById(Long id) {
        return toyRepository.findById(id).get();
    }

    public List<Toy> findAll() {
        return toyRepository.findAll();
    }

    public Toy save(Toy toy) {
        return toyRepository.save(toy);
    }

    public void deleteById(Long id) {
        toyRepository.deleteById(id);
    }

    public boolean update(ToyDto toyDto, long id) {
        Toy toyToUpdate = findById(id);

        toyToUpdate.setName(toyDto.getName());
        toyToUpdate.setToyGroup(toyDto.getToyGroup());
        toyToUpdate.setPrice(toyDto.getPrice());
        toyRepository.save(toyToUpdate);

        return true;
    }
}
