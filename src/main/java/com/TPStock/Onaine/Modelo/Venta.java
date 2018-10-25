package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Venta {
    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;
    private Double total;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles=null;

    public void agregarDetalle(DetalleVenta detalle){
        this.detalles.add(detalle);
    }

}
