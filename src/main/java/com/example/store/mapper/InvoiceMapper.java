package com.example.store.mapper;

import com.example.store.model.Invoice;
import com.example.store.model.dto.InvoiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {InvoiceItemMapper.class})
public interface InvoiceMapper {

    Invoice toInvoice(InvoiceDto invoiceDto);

    List<InvoiceDto> toInvoiceDTOList(List<Invoice> invoices);

}
