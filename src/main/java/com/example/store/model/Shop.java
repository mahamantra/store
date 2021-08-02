package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SHOP")
public class Shop extends BaseEntity{

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "shop")
    private List<ShopItem> shopItems;
}
