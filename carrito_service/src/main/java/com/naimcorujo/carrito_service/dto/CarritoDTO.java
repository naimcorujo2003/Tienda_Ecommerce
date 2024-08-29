package com.naimcorujo.carrito_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {
    private Long id_carrito;
    private Double precio_carrito;
    private List<ProductoDTO> listaProductos;
}
