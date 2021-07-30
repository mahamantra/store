package com.example.store.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "INVOICE_ITEM")
@Entity
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "toy_id")
    private Toy toy;

    @Column(nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}