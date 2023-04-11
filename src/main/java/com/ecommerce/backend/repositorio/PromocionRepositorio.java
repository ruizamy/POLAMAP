package com.ecommerce.backend.repositorio;

import com.ecommerce.backend.modelo.Boletas;
import com.ecommerce.backend.modelo.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionRepositorio extends JpaRepository<Promocion,Integer> {
    @Query(value= "SELECT * from promocion as p where p.nombre=:nombrePromocion", nativeQuery = true)
    public List<Promocion[]> buscarPorNombre(@Param("nombrePromocion") String nombrePromocion);
}
