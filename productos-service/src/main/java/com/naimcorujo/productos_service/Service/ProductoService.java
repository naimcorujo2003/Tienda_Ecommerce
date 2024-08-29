package com.naimcorujo.productos_service.Service;

import com.naimcorujo.productos_service.Model.Producto;
import com.naimcorujo.productos_service.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository produRepo;


    @Override
    public List<Producto> getProductos() {
        return produRepo.findAll();
    }

    @Override
    public  void addProducto(Producto producto) {
        produRepo.save(producto);
    }

    @Override
    public void updateProducto(Long id_producto, Producto prod) {
        this.addProducto(prod);
    }


    @Override
    public void deleteProducto(Long id_producto) {
        produRepo.deleteById(id_producto);

    }

    @Override
    public Producto FindProductosById(Long id_producto) {
        Producto produ = produRepo.findById(id_producto).orElse(null);
        return produ;
    }


}
