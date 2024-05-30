package org.example.entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Jean extends Clothing {
    private String coupe;
    private int length;
}
