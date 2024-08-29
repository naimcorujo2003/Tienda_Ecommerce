package com.naimcorujo.carrito_service.Service;

import com.naimcorujo.carrito_service.Model.Carrito;
import com.naimcorujo.carrito_service.dto.CarritoDTO;


import java.util.List;


public interface ICarritoService {

    public List<Carrito> getCarritos();

    public Carrito getCarritoById(Long id_carrito);
    public void saveCarrito(Carrito carrito, Long id_producto);
    public void deleteCarrito(Long id_carrito);

    void updateCarrito(Carrito carrito, Long id_producto, Long id_carrito);
}
