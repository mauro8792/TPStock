package com.TPStock.Onaine.Repositorio;

import com.TPStock.Onaine.Modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {
    Articulo findByNombre(String nombre);
}
