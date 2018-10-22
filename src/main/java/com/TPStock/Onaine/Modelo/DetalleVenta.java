package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue
    private  Long id;
    @ManyToOne
    @JoinColumn(
            name = "fk_id_articulo"
    )
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(
            name = "fk_id_venta"
    )
    private Venta venta;
    private Long cantidad;
    private Double sub_Total;
}
