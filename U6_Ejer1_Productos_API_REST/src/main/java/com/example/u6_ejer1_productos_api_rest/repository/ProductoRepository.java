package com.example.u6_ejer1_productos_api_rest.repository;

import com.example.u6_ejer1_productos_api_rest.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
