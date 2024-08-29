package com.naimcorujo.carrito_service.Controller;

import com.naimcorujo.carrito_service.Model.Carrito;
import com.naimcorujo.carrito_service.Service.ICarritoService;
import com.naimcorujo.carrito_service.dto.CarritoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carritoServ;

    //Guardar Carrito
    @PostMapping("/guardar")
    public String saveCarrito(@RequestBody Carrito carrito, Long id_producto) {
        carritoServ.saveCarrito(carrito, id_producto);
        return "Carrito guardado con exito!";
    }

    //Mostrar carrito
    @GetMapping("/mostrar")
    public List<Carrito> getCarritosAndProductos() {
        return carritoServ.getCarritos();
    }

    //Mostrar carrito por id
    @GetMapping("/mostar/{id_carrito}")
    public Carrito getCarritoById(@PathVariable Long id_carrito) {
        return carritoServ.getCarritoById(id_carrito);
    }

    //Editar carrito
    @PutMapping("/editar/{id_carrito}")
    public Carrito editarCarrito(@PathVariable Long id_carrito,
                                    @RequestBody Carrito carrito, Long id_producto) {

        carritoServ.updateCarrito(carrito, id_producto, id_carrito);
        Carrito carritoEditado = carritoServ.getCarritoById(id_carrito);
        return carritoEditado;
    }

    //Eliminar carrito
    @DeleteMapping("/eliminar/{id_carrito}")
    public String eliminarCarrito(@PathVariable Long id_carrito) {
        carritoServ.deleteCarrito(id_carrito);
        return "Carrito eliminado con exito!";
    }
}
