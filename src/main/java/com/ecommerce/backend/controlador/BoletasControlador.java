package com.ecommerce.backend.controlador;


import com.ecommerce.backend.modelo.Boletas;
import com.ecommerce.backend.servicio.BoletasServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/boleta")
public class BoletasControlador {
    BoletasServicio boletasServicio;

    public BoletasControlador(BoletasServicio boletasServicio){
        this.boletasServicio=boletasServicio;
    }
    List<Boletas> bol= new ArrayList<>();
    @PostMapping("/crear")
    public Object crearBoletas(@RequestBody Boletas boletas){
        return boletasServicio.crearBoletas(boletas);
    }
    @GetMapping("/{idBoletas}")
    public Object buscarBoletaPorId(@PathVariable Integer idBoletas){

        return boletasServicio.buscarBaresPorId(idBoletas);
    }
    @GetMapping("/listar")
    public List<Boletas> buscarTodo(){

        return boletasServicio.buscarTodo();
    }
    @GetMapping("/nombre/{nombreBoleta}")
    public List<Boletas[]> buscarBaresPorNombre(@PathVariable String nombreBoleta){
        return boletasServicio.buscarBaresPorNombre(nombreBoleta);
    }
    @DeleteMapping("/borrar/{idBoletas}")
    public void borrarBoleta(@PathVariable Integer idBoletas){
        boletasServicio.borrarBoletas(idBoletas);
    }
    @PutMapping("/actualizar/{idBoletas}")
    public ResponseEntity<Boletas> actualizarBoleta(@PathVariable  Integer idBoletas, @RequestBody Boletas boletas ){
        boletasServicio.actualizarBoletas(idBoletas,boletas);
        return new  ResponseEntity<Boletas>(boletas, HttpStatus.OK);
    }
}
