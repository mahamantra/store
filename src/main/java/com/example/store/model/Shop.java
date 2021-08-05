package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "SHOP")
public class Shop extends BaseEntity{

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;
}
