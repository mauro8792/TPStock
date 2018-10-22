package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Articulo {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Integer Stock;
    private Integer precio_stock;
    private Integer precio_venta;
    @ManyToOne
    @JoinColumn(
            name = "fk_id_proveedor"
    )
    private Proveedor proveedor;
}
