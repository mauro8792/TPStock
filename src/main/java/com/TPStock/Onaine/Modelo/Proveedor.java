package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
@Getter
@Setter
@Entity
public class Proveedor{

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Long lead_time;




}