package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Modelo.DetalleVenta;
import com.TPStock.Onaine.Modelo.Venta;
import com.TPStock.Onaine.Repositorio.DetalleVentaRepositorio;
import com.TPStock.Onaine.Repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaControladora {
    @Autowired
    private VentaRepositorio ventabd;
    @Autowired
    private DetalleVentaRepositorio detallebd;

    @PostMapping(value = "/")
    public void crearVenta(@RequestBody Venta nuevo) {

        Venta a = new Venta();
        a.setFecha(nuevo.getFecha());
        a.setTotal(nuevo.getTotal());
    /*
        for (int i=0; i<nuevo.getDetalles().size(); i++){
            Double precioLinea=0.0;
            DetalleVenta detalle = new DetalleVenta();
            detalle.setArticulo(nuevo.getDetalles().get(i).getArticulo());
            detalle.setCantidad(nuevo.getDetalles().get(i).getCantidad());
            precioLinea= nuevo.getDetalles().get(i).getArticulo().getPrecio_venta()*nuevo.getDetalles().get(i).getCantidad();
            detalle.setSub_Total(precioLinea);
            a.setTotal(a.getTotal()+detalle.getSub_Total());
            this.detallebd.save(detalle);
            a.agregarDetalle(detalle);
        }
       */
        this.ventabd.save(a);
    }


    @PutMapping(value =  "/{id}/")
    public void agregarDetalles(@RequestBody  Venta nuev, @PathVariable  Long Id) {
        Venta a = this.ventabd.findById(Id).get();
        /*Double precioLinea;

        for (int i=0; i<nuevo.getDetalles().size(); i++) {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setArticulo(nuevo.getDetalles().get(i).getArticulo());
            detalle.setCantidad(nuevo.getDetalles().get(i).getCantidad());
            precioLinea = nuevo.getDetalles().get(i).getArticulo().getPrecio_venta() * nuevo.getDetalles().get(i).getCantidad();
            detalle.setSub_Total(precioLinea);
            a.setTotal(a.getTotal() + detalle.getSub_Total());
            this.detallebd.save(detalle);
        }*/
        a.setTotal(100.0);
        this.ventabd.save(a);

    }






    @GetMapping(value = "/{Id}",produces = "application/json")
    public Venta getById(@PathVariable("Id") Long Id) {

        Venta venta = new Venta();
        venta.setId(this.ventabd.findById(Id).get().getId());
        venta.setFecha(this.ventabd.findById(Id).get().getFecha());
        venta.setTotal(this.ventabd.findById(Id).get().getTotal());
        return venta;
    }

    @GetMapping(value = "/")
    public List getAllVentas() {
        List<Venta> ventas = this.ventabd.findAll();
        return ventas;
    }

}
