package com.example.store.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TOY")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

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
