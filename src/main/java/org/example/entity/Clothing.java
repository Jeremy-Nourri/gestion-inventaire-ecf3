package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Categorie categorie;
    private String description;
    private String size;
    private double price;
    private int stock;
}
