package org.example.entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Shirt extends Clothing {
    private TypeOfSleeve typeOfSleeve;
    private TypeOfCollar typeOfCollar;

}
