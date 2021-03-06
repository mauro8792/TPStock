package com.TPStock.Onaine.Repositorio;

import com.TPStock.Onaine.Modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {
    Articulo findByNombre(String nombre);
}
