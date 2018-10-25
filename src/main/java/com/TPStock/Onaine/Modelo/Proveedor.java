package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Proveedor{

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Long lead_time;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Articulo> arti=null;

    public void agregarArticulo(Articulo articulo){
        this.arti.add(articulo);
    }

}