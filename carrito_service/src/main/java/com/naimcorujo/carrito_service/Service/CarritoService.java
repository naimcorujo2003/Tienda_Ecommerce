package com.naimcorujo.carrito_service.Service;

import com.naimcorujo.carrito_service.Model.Carrito;
import com.naimcorujo.carrito_service.Repository.ICarritoRepository;
import com.naimcorujo.carrito_service.Repository.IProductoAPI;
import com.naimcorujo.carrito_service.dto.CarritoDTO;
import com.naimcorujo.carrito_service.dto.ProductoDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarritoService implements ICarritoService {

    @Autowired
    private ICarritoRepository carritoRepo;

    @Autowired
     private IProductoAPI produAPI;

    @Override
    @CircuitBreaker(name = "producto_service", fallbackMethod = "fallbackProductoService")
    @Retry(name = "producto_service")
    public void saveCarrito(Carrito carrito, Long id_producto) {
        Carrito carrito1 = new Carrito();

        List<ProductoDTO> listaProductos = produAPI.getProductoById(id_producto);

        Double precioCarrito = 0.0;
        for(ProductoDTO productoDTO:listaProductos){
            if(productoDTO.getPrecio() != null){
                Double precio = productoDTO.getPrecio();
                precioCarrito =+ precio;
            }
        }
        carrito1.setPrecio_carrito(precioCarrito);
        CarritoDTO carritoDTO = new CarritoDTO(carrito.getId_carrito(), precioCarrito,
                listaProductos);

        carritoRepo.save(carrito);
    }

    @Override
    public List<Carrito> getCarritos() {
        return carritoRepo.findAll() ;
    }

    @Override
    public Carrito getCarritoById(Long id_carrito) {
        return carritoRepo.findById(id_carrito).orElse(null);
    }



    @Override
    public void deleteCarrito(Long id_carrito) {
        carritoRepo.deleteById(id_carrito);
    }

    @Override
    public void updateCarrito(Carrito carrito, Long id_producto, Long id_carrito) {
        Carrito carrito1 = carritoRepo.findById(id_carrito).orElse(null);
        List<ProductoDTO> listaProductos = produAPI.getProductoById(id_producto);
        Double precioCarrito = 0.0;
        for(ProductoDTO productoDTO:listaProductos){
            if(productoDTO.getPrecio() != null){
                Double precio = productoDTO.getPrecio();
                precioCarrito =+ precio;
            }
        }
        carrito1.setPrecio_carrito(precioCarrito);
        carritoRepo.save(carrito1);
    }

    public Carrito fallbackProductoService(Throwable throwable) {
        return new Carrito(99999L, null);
    }
}
