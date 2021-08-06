package com.example.store.mapper;

import com.example.store.model.ShopOrder;
import com.example.store.model.dto.ShopOrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopOrderMapper {

    ShopOrder toShopOrder(ShopOrderDto shopOrderDto);

    List<ShopOrderDto> toShopOrderDtoList(List<ShopOrder> shopOrderList);

}
