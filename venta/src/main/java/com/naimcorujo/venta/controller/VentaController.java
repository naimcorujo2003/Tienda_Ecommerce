package com.naimcorujo.venta.controller;

import com.naimcorujo.venta.dto.VentaDTO;
import com.naimcorujo.venta.model.Venta;
import com.naimcorujo.venta.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @PostMapping("/guardar")
    public String saveVenta(@RequestBody Venta venta, Long id_carrito) {
        ventaService.saveVenta(venta, id_carrito);
        return "Venta guardada con exito!";
    }

    @GetMapping("/mostrar}")
    public List<Venta> getVenta() {
        return ventaService.getVentas();
    }

    @GetMapping("/mostrar/{id_venta}")
    public Venta getVentaById(@PathVariable Long id_venta) {
        return ventaService.getVentaByID(id_venta);
    }

    @DeleteMapping("/borrar/{id_venta}")
    public String deleteVenta(@PathVariable Long id_venta) {
        ventaService.deleteVenta(id_venta);
        return "Venta eliminada con exito!";
    }

    @PutMapping("(/editar/{id_venta})")
    public Venta editVenta(@PathVariable Long id_venta, @RequestBody Venta venta, Long id_carrito) {
        ventaService.updateVenta(venta, id_carrito, id_venta);
        Venta ventaEditada = ventaService.getVentaByID(id_venta);
        return ventaEditada;
    }


}
