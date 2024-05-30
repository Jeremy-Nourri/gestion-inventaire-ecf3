package org.example.entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Jacket extends Clothing {
    TypeOfJacket typeOfJacket;
    TypeOfSeason typeOfSeason;
}
