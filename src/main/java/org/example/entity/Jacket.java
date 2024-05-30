package org.example.entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Jacket extends Clothing {
    TypeOfJacket typeOfJacket;
    TypeOfSeason typeOfSeason;
}
