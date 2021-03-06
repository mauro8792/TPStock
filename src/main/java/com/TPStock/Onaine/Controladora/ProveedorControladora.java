package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Modelo.Articulo;
import com.TPStock.Onaine.Modelo.Proveedor;
import com.TPStock.Onaine.Repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorControladora {
    @Autowired
    private ProveedorRepositorio bd;

    @PostMapping(value = "/")
    public void crearProveedor(@RequestBody Proveedor nuevo) {
         Proveedor prov = new Proveedor();
         prov.setLead_time(nuevo.getLead_time());
         prov.setNombre(nuevo.getNombre());
         this.bd.save(prov);
    }


    // los proveedores no se eliminan

    @DeleteMapping(value = "/{nombre}")
    public void deleteProveedorNombre(@PathVariable("nombre") String nombre) {
        Proveedor prov = new Proveedor();
        prov.setId(this.bd.findByNombre(nombre).getId());
        prov.setNombre(this.bd.findByNombre(nombre).getNombre());
        prov.setLead_time(this.bd.findByNombre(nombre).getLead_time());
        this.bd.delete(prov);

    }

    @GetMapping(value = "/{nombre}",produces = "application/json")
    public Proveedor getByName(@PathVariable("nombre") String nombre) {

        Proveedor prov = new Proveedor();
        prov.setId(this.bd.findByNombre(nombre).getId());
        prov.setNombre(this.bd.findByNombre(nombre).getNombre());
        prov.setLead_time(this.bd.findByNombre(nombre).getLead_time());
        return prov;
    }

    @GetMapping(value = "/")
    public List getAllProvider() {
        List<Proveedor> proveedores = this.bd.findAll();
        for(Proveedor p: proveedores){
            for(Articulo a : p.getArti()){
                a.setProveedor(null);
            }
        }
        return proveedores;
    }


}
