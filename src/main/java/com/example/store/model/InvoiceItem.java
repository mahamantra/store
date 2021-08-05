package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "INVOICE_ITEM")
@Entity
public class InvoiceItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "toy_id")
    private Toy toy;

    @Column(nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonIgnore
    private Invoice invoice;
}