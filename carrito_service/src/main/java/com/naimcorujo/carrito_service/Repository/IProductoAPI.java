package com.naimcorujo.carrito_service.Repository;

import com.naimcorujo.carrito_service.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="productos-service")
public interface IProductoAPI {

     @GetMapping("/producto/mostrar/{id_producto}")
    public List<ProductoDTO> getProductoById(@PathVariable("id_producto") Long id_producto);
}
