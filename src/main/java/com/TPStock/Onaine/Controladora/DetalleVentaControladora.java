package com.TPStock.Onaine.Controladora;

import com.TPStock.Onaine.Repositorio.DetalleVentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalle")
public class DetalleVentaControladora {
    @Autowired
    private DetalleVentaRepositorio bd;


}
