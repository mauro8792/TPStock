package com.TPStock.Onaine.Modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@Entity
public class Venta {
    @Id
    @GeneratedValue
    private Long id;
    private Date fecha;
    private Long total;
}
