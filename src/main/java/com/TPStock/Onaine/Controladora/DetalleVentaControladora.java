package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Modelo.Articulo;
import com.TPStock.Onaine.Modelo.DetalleVenta;
import com.TPStock.Onaine.Modelo.Venta;
import com.TPStock.Onaine.Repositorio.ArticuloRepositorio;
import com.TPStock.Onaine.Repositorio.DetalleVentaRepositorio;
import com.TPStock.Onaine.Repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetalleVentaControladora {
    @Autowired
    private DetalleVentaRepositorio bd;
    @Autowired
    private VentaRepositorio ventaDb;
    @Autowired
    private ArticuloRepositorio artiDb;

    @PostMapping(value = "/")
    public void crearDetalleVenta(@RequestBody DetalleVenta nuevo) {

        Venta a= ventaDb.getOne(nuevo.getVenta().getId());
        nuevo.calcularSubTotal();
        a.setTotal(a.getTotal()+nuevo.getSub_Total());
        Articulo arti= new Articulo();
        arti=this.artiDb.findByNombre(nuevo.getArticulo().getNombre());
        arti.setStock(arti.getStock()-nuevo.getCantidad());
        artiDb.save(arti);
        ventaDb.save(a);
        bd.save(nuevo);

    }


}
