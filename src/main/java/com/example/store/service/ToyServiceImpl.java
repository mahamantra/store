package com.example.store.service;

import com.example.store.model.Toy;
import com.example.store.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToyServiceImpl implements ToyService {

    private final ToyRepository toyRepository;

    @Override
    public Toy findById(Long id) {
        return toyRepository.getById(id);
    }

    @Override
    public List<Toy> findAll() {
        return toyRepository.findAll();
    }

    @Override
    public Toy saveToy(Toy toy) {
        return toyRepository.save(toy);
    }

    @Override
    public void deleteById(Long id) {
        toyRepository.deleteById(id);
    }

    @Override
    public boolean update(Toy toy, long id) {
        Toy toyToUpdate = toyRepository.getById(id);
        if (toyToUpdate == null) {
            return false;
        }
        toyToUpdate.setName(toy.getName());
        toyToUpdate.setToyGroup(toy.getToyGroup());
        toyToUpdate.setPrice(toy.getPrice());
        toyRepository.save(toyToUpdate);

        return true;
    }
}
