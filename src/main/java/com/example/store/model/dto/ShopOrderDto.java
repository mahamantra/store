package com.example.store.model.dto;

import com.example.store.model.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShopOrderDto {

    private List<OrderItem> orderItems;
    private LocalDateTime date;

}
