package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "SHOP_ITEM")
public class ShopItem extends BaseEntity{

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
