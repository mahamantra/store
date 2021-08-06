package com.example.store.service;

import com.example.store.model.ToyGroup;
import com.example.store.repository.ToyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToyGroupService {

    private final ToyGroupRepository toyGroupRepository;

    public List<ToyGroup> findAll() {
    return toyGroupRepository.findAll();
    }

    public ToyGroup save(ToyGroup toyGroup){
      return toyGroupRepository.save(toyGroup);
    }
}
