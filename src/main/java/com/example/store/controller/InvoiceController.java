package com.example.store.controller;

import com.example.store.mapper.InvoiceMapper;
import com.example.store.model.Invoice;
import com.example.store.model.dto.InvoiceDto;
import com.example.store.service.InvoiceService;
import io.swagger.annotations.Api;
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
@Api
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/invoicies")
    public ResponseEntity<List<InvoiceDto>> findAll() {
        List<Invoice> invoices = invoiceService.findAll();
        List<InvoiceDto> invoiceDtoList = Mappers.getMapper(InvoiceMapper.class).toInvoiceDTOList(invoices);
        return new ResponseEntity<>(invoiceDtoList, HttpStatus.OK);
    }

    @PostMapping("/invoicies")
    public ResponseEntity<?> create(@RequestBody InvoiceDto invoiceDto){
        invoiceService.save(Mappers.getMapper(InvoiceMapper.class).toInvoice(invoiceDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
