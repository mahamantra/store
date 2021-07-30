package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TOY")
public class Toy extends BaseEntity{

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TOY_GROUP_ID", nullable = false)
    private ToyGroup toyGroup;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;
}
