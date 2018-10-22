package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Modelo.Venta;
import com.TPStock.Onaine.Repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaControladora {
    @Autowired
    private VentaRepositorio bd;

    @PostMapping(value = "/")
    public void crearVenta(@RequestBody Venta nuevo) {
        Venta venta = new Venta();
        venta.setFecha(nuevo.getFecha());
        venta.setTotal(nuevo.getTotal());
        this.bd.save(venta);
    }
/*
    @GetMapping(value = "/{Id}",produces = "application/json")
    public Venta getById(@PathVariable("Id") Long Id) {

        Venta venta = new Venta();
        venta.setId(this.bd.findByIds(Id).getId());
        venta.setFecha(this.bd.findByIds(Id).getFecha());
        venta.setTotal(this.bd.findByIds(Id).getTotal());
        return venta;
    }
*/
    @GetMapping(value = "/")
    public List getAllVentas() {
        List<Venta> ventas = this.bd.findAll();
        return ventas;
    }

}
