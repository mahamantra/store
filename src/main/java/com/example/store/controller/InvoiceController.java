package com.example.store.controller;

import com.example.store.mapper.InvoiceMapper;
import com.example.store.model.Invoice;
import com.example.store.model.dto.InvoiceDto;
import com.example.store.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(
        value = "Накладные"
)
public class InvoiceController {

    private final InvoiceService invoiceService;


    @ApiOperation(
            value = "Список накладных",
            response = InvoiceDto.class,
            responseContainer = "List"
    )
    @GetMapping("/invoicies")
    public ResponseEntity<List<InvoiceDto>> findAll() {
        List<Invoice> invoices = invoiceService.findAll();
        List<InvoiceDto> invoiceDtoList = Mappers.getMapper(InvoiceMapper.class).toInvoiceDTOList(invoices);
        return new ResponseEntity<>(invoiceDtoList, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Создать накладную"
    )
    @PostMapping("/invoicies")
    public ResponseEntity<?> create(@RequestBody InvoiceDto invoiceDto){
        invoiceService.save(Mappers.getMapper(InvoiceMapper.class).toInvoice(invoiceDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

}
