package com.example.store.mapper;

import com.example.store.model.Toy;
import com.example.store.model.dto.ToyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToyMapper {

    Toy toToy(ToyDto city);
}
