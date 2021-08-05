package com.example.store.model.dto;

import com.example.store.model.InvoiceItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InvoiceDto {

    private LocalDateTime date;
    private List<InvoiceItem> invoiceItems;
}
