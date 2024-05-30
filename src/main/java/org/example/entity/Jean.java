package org.example.entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Jean extends Clothing {
    private String coupe;
    private int length;
}
