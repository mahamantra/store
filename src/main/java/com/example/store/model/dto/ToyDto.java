package com.example.store.model.dto;

import com.example.store.model.ToyGroup;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ToyDto {

    private String name;
    private ToyGroup toyGroup;
    private BigDecimal price;
    private Integer count;
}
