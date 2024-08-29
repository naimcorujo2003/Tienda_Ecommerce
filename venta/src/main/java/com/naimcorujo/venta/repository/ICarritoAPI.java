package com.naimcorujo.venta.repository;

import com.naimcorujo.venta.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="carrito_service")
public interface ICarritoAPI {

    @GetMapping("/carrito/mostrar/{id_carrito}")
    public CarritoDTO getCarritoByID(@PathVariable("id_carrito") Long id_carrito);
}
