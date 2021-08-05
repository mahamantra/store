package com.example.store.repository;

import com.example.store.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToyRepository extends JpaRepository<Toy, Long> {

    List<Toy> findByName(String name);

    List<Toy> findByIdIn(List<Long> toyIds);
}
