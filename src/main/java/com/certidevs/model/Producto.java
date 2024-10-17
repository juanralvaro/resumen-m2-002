package com.certidevs.spring_002_mvc;

import lombok.*;

@Builder
@ToString
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor  // Constructor con todos los parámetros
@Getter
@Setter
public class Producto {
    private Long id;
    private String nombre;
    private Double precio;
    private Boolean activo;
    private String categoria;
}
