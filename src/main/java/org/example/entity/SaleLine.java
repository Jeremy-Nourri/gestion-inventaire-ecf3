package org.example.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "sale_line")
@Entity
public class SaleLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private double total;

    @ManyToOne
    @JoinColumn(name = "clothing_id")
    private Clothing clothing;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
}
