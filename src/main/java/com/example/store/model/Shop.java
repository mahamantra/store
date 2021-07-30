package com.example.store.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "SHOP")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "shop")
    private List<ShopItem> shopItems;
}
