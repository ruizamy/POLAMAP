package com.ecommerce.backend.servicio;


import com.ecommerce.backend.modelo.Boletas;
import com.ecommerce.backend.repositorio.BoletasRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoletasServicio {

        BoletasRepositorio boletasRepositorio;
        public BoletasServicio(BoletasRepositorio boletasRepositorio) {
            this.boletasRepositorio = boletasRepositorio;
        }
        public Object crearBoletas(Boletas boletas){
            return boletasRepositorio.save(boletas);
        }

        public Object buscarBaresPorId(Integer idEstablecimiento){
            return boletasRepositorio.findById(idEstablecimiento);
        }

        public List<Boletas[]> buscarBaresPorNombre(String nombreBoletas){
            return boletasRepositorio.buscarPorNombre(nombreBoletas);
        }
        public List<Boletas> buscarTodo(){
            return boletasRepositorio.findAll();
        }

        public void borrarBoletas(Integer idBoletas){
            boletasRepositorio.deleteById(idBoletas);
        }

        public void actualizarBoletas(Integer idBoletas, Boletas boletas)  {

            Boletas bol = boletasRepositorio.getById(idBoletas);
            bol.setNombreBoleta(boletas.getNombreBoleta());
            bol.setDescripcionBoleta(boletas.getDescripcionBoleta());
            bol.setPrecio(boletas.getPrecio());
            bol.setCantidad(boletas.getCantidad());
            bol.setImgUrlBoleta(boletas.getImgUrlBoleta());
            bol.setFechaBoleta(boletas.getFechaBoleta());
            boletasRepositorio.save(bol);
        }


    }


