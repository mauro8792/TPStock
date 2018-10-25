package com.TPStock.Onaine.Repositorio;

import com.TPStock.Onaine.Modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>{
   Proveedor findByNombre(String nombre);
}
