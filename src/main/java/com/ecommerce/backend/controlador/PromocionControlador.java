package com.ecommerce.backend.controlador;


import com.ecommerce.backend.modelo.Promocion;
import com.ecommerce.backend.servicio.PromocionServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/promocion")
public class PromocionControlador {
    PromocionServicio promocionServicio;

    public PromocionControlador(PromocionServicio promocionServicio){

        this.promocionServicio=promocionServicio;
    }
    List<Promocion> pro= new ArrayList<>();
    @PostMapping("/crear")
    public Object crearPromocion(@RequestBody Promocion promocion){
        return promocionServicio.crearPromocion(promocion);
    }
    @GetMapping("/{idPromocion}")
    public Object buscarPromocionPorId(@PathVariable Integer idPromocion){

        return promocionServicio.buscarPromocionPorId(idPromocion);
    }
    @GetMapping("/listar")
    public List<Promocion> buscarTodo(){

        return promocionServicio.buscarTodo();

    }
    @GetMapping("/nombre/{nombrePromocion}")
    public List<Promocion[]> buscarBaresPorNombre(@PathVariable String nombrePromocion){
        return promocionServicio.buscarPromocionPorNombre(nombrePromocion);
    }
    @DeleteMapping("/borrar/{idPromocion}")
    public void borrarBares(@PathVariable Integer idBoletas){
        promocionServicio.borrarPromocion(idBoletas);
    }
    @PutMapping("/actualizar/{idPromocion}")
    public ResponseEntity<Promocion> actualizarPromocion(@PathVariable  Integer idPromocion, @RequestBody Promocion promocion ){
        promocionServicio.actualizarPromocion(idPromocion,promocion);
        return new  ResponseEntity<Promocion>(promocion, HttpStatus.OK);
    }
}
