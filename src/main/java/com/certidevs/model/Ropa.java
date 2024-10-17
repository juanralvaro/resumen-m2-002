package com.certidevs.model;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ropa {

    Long id;
    String nombre;
    String tamano;
    String material;

}
