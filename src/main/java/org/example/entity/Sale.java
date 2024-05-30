package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Clothing clothing;

    @ManyToOne
    private Customer customer;

    private StateSale stateSale;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleLine> saleLines;

}
