package com.naimcorujo.carrito_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ProductoDTO {
    private Long id_producto;
    private String nombre;
    private String marca;
    private Double precio;

}
