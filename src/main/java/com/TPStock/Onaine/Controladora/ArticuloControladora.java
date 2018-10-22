package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Modelo.Articulo;
import com.TPStock.Onaine.Repositorio.ArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
public class ArticuloControladora {
    @Autowired
    private ArticuloRepositorio bd;

    @PostMapping(value = "/")
    public void crearProveedor(@RequestBody Articulo nuevo) {
        Articulo arti = new Articulo();
        arti.setNombre(nuevo.getNombre());
        arti.setPrecio_stock(nuevo.getPrecio_stock());
        arti.setPrecio_venta(nuevo.getPrecio_venta());
        arti.setStock(nuevo.getStock());
        this.bd.save(arti);
    }

    @DeleteMapping(value = "/{nombre}")
    public void deleteArticuloNombre(@PathVariable("nombre") String nombre) {
        Articulo arti = new Articulo();
        arti.setNombre(this.bd.findByNombre(nombre).getNombre());
        arti.setPrecio_stock(this.bd.findByNombre(nombre).getPrecio_stock());
        arti.setPrecio_venta(this.bd.findByNombre(nombre).getPrecio_venta());
        arti.setStock(this.bd.findByNombre(nombre).getStock());
        this.bd.delete(arti);
    }
    @GetMapping(value = "/{nombre}",produces = "application/json")
    public Articulo getByName(@PathVariable("nombre") String nombre) {

        Articulo arti = new Articulo();
        arti.setId(this.bd.findByNombre(nombre).getId());
        arti.setNombre(this.bd.findByNombre(nombre).getNombre());
        arti.setPrecio_stock(this.bd.findByNombre(nombre).getPrecio_stock());
        arti.setPrecio_venta(this.bd.findByNombre(nombre).getPrecio_venta());
        arti.setStock(this.bd.findByNombre(nombre).getStock());
        return arti;
    }
    @GetMapping(value = "/")
    public List getAllArticulos() {
        List<Articulo> articulos = this.bd.findAll();
        return articulos;
    }
}
