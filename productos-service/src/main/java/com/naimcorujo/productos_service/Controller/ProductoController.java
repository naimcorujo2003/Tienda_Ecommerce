package com.naimcorujo.productos_service.Controller;

import com.naimcorujo.productos_service.Model.Producto;
import com.naimcorujo.productos_service.Service.IProductoService;
import com.naimcorujo.productos_service.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableDiscoveryClient
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductoService produServ;

    //Guardar productos
    @PostMapping("/guardar")
    public String addProductos(@RequestBody Producto producto) {
        produServ.addProducto(producto);
        return "Producto creado";
    }


    //Traer productos
    @GetMapping("/mostrar")
    public List<Producto> getProductos(){
        return produServ.getProductos();
    }

    //Traer producto por id
    @GetMapping("/mostrar/{id_producto}")
    public Producto getProducto(@PathVariable Long id_producto){
        return produServ.FindProductosById(id_producto);
    }

    //Editar producto
    @PutMapping("/editar/{id_producto}")
    public Producto updateProducto(@PathVariable Long id_producto, @RequestBody Producto producto) {
        produServ.updateProducto(id_producto, producto);
        Producto productoEditado = produServ.FindProductosById(id_producto);
        return productoEditado;
    }

    //Eliminar producto
    @DeleteMapping("/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable Long id_producto){
        produServ.deleteProducto(id_producto);
        return "Producto eliminado";
    }
}
