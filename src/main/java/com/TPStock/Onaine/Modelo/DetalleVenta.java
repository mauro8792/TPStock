package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "fk_id_articulo"
    )
    private Articulo articulo;
    private Double cantidad;
    private Double sub_Total;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "fk_id_venta"
    )
    private Venta venta;

    public void calcularSubTotal(){
         this.sub_Total=(this.cantidad * this.articulo.getPrecio_venta());

    }
}
