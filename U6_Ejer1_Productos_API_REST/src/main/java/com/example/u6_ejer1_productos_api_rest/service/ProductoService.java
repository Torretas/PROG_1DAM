package com.example.u6_ejer1_productos_api_rest.service;

import com.example.u6_ejer1_productos_api_rest.model.Producto;
import com.example.u6_ejer1_productos_api_rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(int id) {
        return productoRepository.findById(id).get();
    }

    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> updateProducto(Integer id, Producto productoActualizado) {
       Optional<Producto> productoOptional = productoRepository.findById(id);
       if (productoOptional.isPresent()) {
           Producto producto = productoOptional.get();
           producto.setNombre(productoActualizado.getNombre());
           producto.setPrecio(productoActualizado.getPrecio());
           return Optional.of(productoRepository.save(producto));
       }
       return Optional.empty();
    }

    public boolean deleteProducto(Integer id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
