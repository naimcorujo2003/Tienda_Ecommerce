package com.naimcorujo.productos_service.Service;

import com.naimcorujo.productos_service.Model.Producto;


import java.util.List;

public interface IProductoService {
    public List<Producto> getProductos();
    public void addProducto(Producto producto);
    public void updateProducto(Long id_producto, Producto prod);
    public void deleteProducto(Long id_producto);
    public Producto FindProductosById(Long id_producto);
}
