package com.naimcorujo.venta.service;

import com.naimcorujo.venta.model.Venta;

import java.util.List;


public interface IVentaService {
    public List<Venta> getVentas();

    public Venta getVentaByID(Long venta_id);
    public void saveVenta(Venta venta, Long id_carrito);
    public void updateVenta(Venta venta, Long id_venta, Long id_carrito);
    public void deleteVenta(Long venta_id);
}
