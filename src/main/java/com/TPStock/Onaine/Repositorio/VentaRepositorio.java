package com.TPStock.Onaine.Repositorio;

import com.TPStock.Onaine.Modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long> {

}
