package com.example.store.controller;

import com.example.store.mapper.ToyGroupMapper;
import com.example.store.model.ToyGroup;
import com.example.store.model.dto.ToyGroupDto;
import com.example.store.service.ToyGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(
        value = "Группа товаров"
)
public class ToyGroupController {

    private final ToyGroupService toyGroupService;

    @ApiOperation(value = "Список всех групп")
    @GetMapping("/groups")
    public ResponseEntity<List<ToyGroupDto>> findAll() {
        List<ToyGroupDto> toyGroupDtoList = Mappers.getMapper(ToyGroupMapper.class).toToyGroupDtoList(toyGroupService.findAll());
        return new ResponseEntity<>(toyGroupDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "Создать группу")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToyGroupDto toyGroupDto) {
        ToyGroup toyGroup = Mappers.getMapper(ToyGroupMapper.class).toToyGroup(toyGroupDto);
        toyGroupService.save(toyGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
