package com.example.store.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TOY_ID")
    private Toy toy;

    @ManyToOne
    @JoinColumn(name = "SHOP_ORDER_ID")
    private ShopOrder order;
}
