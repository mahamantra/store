package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JsonIgnore
    private ShopOrder order;

    @Column(nullable = false)
    private Integer count;
}
