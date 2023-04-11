package com.ecommerce.backend.repositorio;


import com.ecommerce.backend.modelo.Boletas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletasRepositorio extends JpaRepository<Boletas,Integer> {
    @Query(value= "SELECT * from boletas as b where b.nombre_boletas=:nombreBoletas", nativeQuery = true)
    public List<Boletas[]> buscarPorNombre(@Param("nombreBoletas") String nombreBoletas);
}