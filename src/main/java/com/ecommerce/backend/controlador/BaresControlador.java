package com.ecommerce.backend.controlador;

import com.ecommerce.backend.modelo.Bares;
import com.ecommerce.backend.servicio.BaresServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/bares")
public class BaresControlador {

  BaresServicio baresServicio;

    public BaresControlador(BaresServicio baresServicio){
        this.baresServicio=baresServicio;
    }
    List<Bares> bar= new ArrayList<>();

@PostMapping("/crear")
    public Object crearBares(@RequestBody Bares bares){

    return baresServicio.crearBares(bares);
    }
    @GetMapping("/{idEstablecimiento}")
    public Object buscarBaresPorId(@PathVariable Integer idEstablecimiento){

        return baresServicio.buscarBaresPorId(idEstablecimiento);
    }
    @GetMapping("/listar-bares")
    public List<Bares> buscarTodo(){

        return baresServicio.buscarTodo();
    }
    @GetMapping("/nombre/{nombreEstable}")
    public List<Bares[]> buscarBaresPorNombre(@PathVariable String nombreEstable){
        return baresServicio.buscarBaresPorNombre(nombreEstable);
    }
    @DeleteMapping("/borrar/{idEstablecimiento}")
    public void borrarBares(@PathVariable Integer idEstablecimiento){
        baresServicio.borrarBares(idEstablecimiento);
    }
    @PutMapping("/actualizar/{idEstablecimiento}")
    public ResponseEntity<Bares> actualizarBares(@PathVariable  Integer idEstablecimiento, @RequestBody Bares bares ){
    baresServicio.actualizarBares(idEstablecimiento,bares);
    return new  ResponseEntity<Bares>(bares, HttpStatus.OK) ;
    }
    @PutMapping("/actualizar-nombre/{idEstablecimiento}")
    public String actualizarNombreBar (  @RequestBody Bares bares ,@PathVariable Integer idEstablecimiento){
     baresServicio.actualizarNombreBar(bares.getNombreEstable(), idEstablecimiento);
        return "Exito";
    }

}
