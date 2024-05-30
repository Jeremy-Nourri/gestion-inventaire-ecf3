package org.example.entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Shirt extends Clothing {
    private TypeOfSleeve typeOfSleeve;
    private TypeOfCollar typeOfCollar;

}
