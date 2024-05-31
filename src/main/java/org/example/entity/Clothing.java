package org.example.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)

public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    private String description;
    private String size;
    private double price;
    private int stock;
}
