package org.example.entity;

import lombok.*;
import org.example.observer.Observer;
import org.example.observer.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Sale implements Subject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer customer;

    @Column(name = "state_sale")
    @Enumerated(EnumType.STRING)
    private StateSale stateSale;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SaleLine> saleLines;

    @Transient
    private Observer observer;

    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver(Observer observer) {
    }

    @Override
    public void notifyObservers() {
        observer.update(this);
    }

}

