package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "INVOICE")
public class Invoice extends BaseEntity{

    @Column(nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InvoiceItem> invoiceItems;

}
