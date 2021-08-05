package com.example.store.model.dto;

import com.example.store.model.Invoice;
import com.example.store.model.Toy;
import lombok.Data;

@Data
public class InvoiceItemDto {

    private Toy toy;
    private Integer count;
    private Invoice invoice;

}
