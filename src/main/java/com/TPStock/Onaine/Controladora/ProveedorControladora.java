package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Modelo.Proveedor;
import com.TPStock.Onaine.Repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @DeleteMapping(value = "/{Id}")
    public void deleteProveedorNombre(@PathVariable("Id") Long Id) {
        Proveedor prov = new Proveedor();
        prov.setId(this.bd.findById(Id).get().getId());
        prov.setNombre(this.bd.findById(Id).get().getNombre());
        prov.setLead_time(this.bd.findById(Id).get().getLead_time());
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
        return proveedores;
    }

}
