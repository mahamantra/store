package com.example.store.controller;

import com.example.store.mapper.ToyMapper;
import com.example.store.model.Toy;
import com.example.store.model.dto.ToyDto;
import com.example.store.service.ToyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(
        value = "Игрушки"
)
public class ToyController {

    private final ToyService toyService;

    @ApiOperation(
            value = "Список всех игрушек"
    )
    @GetMapping("/toys")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<List<Toy>> findAll() {
        List<Toy> toys = toyService.findAll();
        return new ResponseEntity<>(toys, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Создать игрушку"
    )
    @PostMapping("/toys")
    @PreAuthorize("hasAuthority('developers:write')")
    public ResponseEntity<?> create(@RequestBody ToyDto toyDto){
        toyService.save(Mappers.getMapper(ToyMapper.class).toToy(toyDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(
            value = "Найти игрушку по id"
    )
    @GetMapping("/toys/{id}")
    public ResponseEntity<Toy> findById(@PathVariable(name = "id") long id){
        Toy toy = toyService.findById(id);
        return new ResponseEntity<>(toy, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Редактировать игрушку"
    )
    @PutMapping("/toys/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id,@RequestBody ToyDto toyDto){
        boolean updated = toyService.update(toyDto, id);

        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удалить игрушку"
    )
    @DeleteMapping("/toys/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        toyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
    }
}
