package com.TPStock.Onaine.Modelo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
@Data
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Long lead_time;

}