package com.example.store.mapper;

import com.example.store.model.InvoiceItem;
import com.example.store.model.dto.InvoiceItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface InvoiceItemMapper {

    InvoiceItem toInvoiceItem(InvoiceItemDto invoiceItemDto);

    List<InvoiceItemDto> toInvoiceItemDTOList(List<InvoiceItem> invoiceItems);
}
