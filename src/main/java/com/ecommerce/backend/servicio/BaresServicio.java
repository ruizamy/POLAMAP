package com.ecommerce.backend.servicio;

import com.ecommerce.backend.modelo.Bares;
import jakarta.persistence.criteria.CriteriaBuilder;
import com.ecommerce.backend.repositorio.BaresRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BaresServicio {

    BaresRepositorio baresRepositorio;
    public BaresServicio(BaresRepositorio baresRepositorio) {
        this.baresRepositorio = baresRepositorio;
    }
    public Object crearBares(Bares bares){

        return baresRepositorio.save(bares);
    }

    public Object buscarBaresPorId(Integer idEstablecimiento){
        return baresRepositorio.findById(idEstablecimiento);
    }

    public List<Bares[]> buscarBaresPorNombre(String nombreEstable){
        return baresRepositorio.buscarPorNombre(nombreEstable);
    }
    public List<Bares> buscarTodo(){
        return baresRepositorio.findAll();
    }

    public void borrarBares(Integer idEstablecimiento){
        baresRepositorio.deleteById(idEstablecimiento);
    }

    public void actualizarBares(Integer idEstablecimiento, Bares bares)  {

        Bares barr = baresRepositorio.getById(idEstablecimiento);
        barr.setNombreEstable(bares.getNombreEstable());
        barr.setDescripcionEstable(bares.getDescripcionEstable());
        barr.setOferta(bares.getOferta());
        barr.setImgUrlEstable(bares.getImgUrlEstable());
        baresRepositorio.save(barr);
    }
    @Transactional
    public Integer actualizarNombreBar (String nombreEstable, Integer id){
        return baresRepositorio.actualizarNombre(nombreEstable, id);
    }


}

