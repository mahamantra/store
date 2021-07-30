package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseEntity{

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TOY_ID")
    private Toy toy;

    @ManyToOne
    @JoinColumn(name = "SHOP_ORDER_ID")
    private ShopOrder order;
}
