package com.example.store.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InvoiceItem> invoiceItems;

}
