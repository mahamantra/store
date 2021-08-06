package com.example.store.mapper;

import com.example.store.model.ToyGroup;
import com.example.store.model.dto.ToyGroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToyGroupMapper {

    ToyGroup toToyGroup(ToyGroupDto toyGroupDto);

    @Mappings(
            @Mapping(source = "id",target = "id")
    )
    ToyGroupDto toToyGroupDto(ToyGroup toyGroup);

    List<ToyGroupDto> toToyGroupDtoList(List<ToyGroup> toyGroupList);

}
