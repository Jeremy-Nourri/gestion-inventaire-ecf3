package org.example.entity;

import lombok.*;
import org.example.observer.Observer;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Customer implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Sale> purchaseList;

    @Override
    public void update(Sale sale) {
        System.out.println("------------------------------------------");
        System.out.println("Votre commande " + sale.getId() + " est " + sale.getStateSale() + " !");
        System.out.println("------------------------------------------");
    }

}
