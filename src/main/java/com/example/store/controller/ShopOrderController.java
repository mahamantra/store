package com.example.store.controller;

import com.example.store.mapper.ShopOrderMapper;
import com.example.store.model.ShopOrder;
import com.example.store.model.dto.ShopOrderDto;
import com.example.store.service.ShopOrderService;
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
        value = "Заказы"
)
public class ShopOrderController {

    private final ShopOrderService shopOrderService;

    @ApiOperation(
            value = "Все заказы"
    )
    @GetMapping("/shopOrders")
    public ResponseEntity<List<ShopOrderDto>> findAll() {
        List<ShopOrder> shopOrders = shopOrderService.findAll();
        List<ShopOrderDto> shopOrderDtoList = Mappers.getMapper(ShopOrderMapper.class).toShopOrderDtoList(shopOrders);
        return new ResponseEntity<>(shopOrderDtoList, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Создать заказ"
    )
    @PostMapping("/shopOrders")
    public ResponseEntity<?> create(@RequestBody ShopOrderDto shopOrderDto){
        shopOrderService.save(Mappers.getMapper(ShopOrderMapper.class).toShopOrder(shopOrderDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
