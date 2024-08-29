package com.naimcorujo.venta.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
        private Long id_venta;
        private Date fecha;
        private List<CarritoDTO> listaCarrito;
}
