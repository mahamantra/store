package com.example.store.controller;

import com.example.store.mapper.ToyMapper;
import com.example.store.model.Toy;
import com.example.store.model.dto.ToyDto;
import com.example.store.service.ToyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api
public class ToyController {

    private final ToyService toyService;

    @GetMapping("/toys")
    public ResponseEntity<List<Toy>> findAll() {
        List<Toy> toys = toyService.findAll();
        return new ResponseEntity<>(toys, HttpStatus.OK);
    }

    @PostMapping("/toys")
    public ResponseEntity<?> create(@RequestBody ToyDto toyDto){
        toyService.saveToy(Mappers.getMapper(ToyMapper.class).toToy(toyDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/toys/{id}")
    public ResponseEntity<Toy> findById(@PathVariable(name = "id") long id){
        Toy toy = toyService.findById(id);
        return new ResponseEntity<>(toy, HttpStatus.OK);
    }

    @PutMapping("/toys/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id,@RequestBody Toy toy){
        boolean updated = toyService.update(toy, id);

        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/toys/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        toyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
