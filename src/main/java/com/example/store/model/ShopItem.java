package com.example.store.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "SHOP_ITEM")
public class ShopItem {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "TOY_ID")
    private Toy toy;

    @NotNull
    @Column(nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private Shop shop;
}
