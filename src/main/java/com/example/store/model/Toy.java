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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        return getId().equals(toy.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @NotNull
    @Column(nullable = false)
    private Integer count;
}
