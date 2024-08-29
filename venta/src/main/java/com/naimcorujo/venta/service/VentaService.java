package com.naimcorujo.venta.service;

import com.naimcorujo.venta.dto.CarritoDTO;
import com.naimcorujo.venta.dto.VentaDTO;
import com.naimcorujo.venta.model.Venta;
import com.naimcorujo.venta.repository.ICarritoAPI;
import com.naimcorujo.venta.repository.IVentaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private ICarritoAPI carritoAPI;

    @Override
    public void deleteVenta(Long venta_id) {
        ventaRepository.deleteById(venta_id);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaByID(Long venta_id) {
        return ventaRepository.findById(venta_id).orElse(null);
    }

    @Override
    @CircuitBreaker(name = "carrito_service", fallbackMethod = "fallbackVentaService")
    @Retry(name = "carrito_service")
    public void saveVenta(Venta venta, Long id_carrito) {

        CarritoDTO carrito1= carritoAPI.getCarritoByID(id_carrito);
        Long idCarrito1 = carrito1.getId_carrito();

        Venta venta1 = new Venta();
        venta1.setId_carrito(idCarrito1);

        ventaRepository.save(venta1);
    }


    public VentaDTO fallbackVentaService(Throwable throwable) {
        return  new VentaDTO(999999999L, null, null);
    }

    @Override
    public void updateVenta(Venta venta, Long id_venta, Long id_carrito) {
        this.saveVenta(venta, id_venta);
    }


}
