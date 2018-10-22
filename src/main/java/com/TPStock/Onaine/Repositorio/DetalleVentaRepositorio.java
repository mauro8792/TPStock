package com.TPStock.Onaine.Repositorio;

import com.TPStock.Onaine.Modelo.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Long> {
}
