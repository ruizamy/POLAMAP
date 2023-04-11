package com.ecommerce.backend.repositorio;

import com.ecommerce.backend.modelo.Bares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface BaresRepositorio extends JpaRepository<Bares,Integer> {
    @Query(value= "SELECT * from establecimientos as u where u.nombre_establecimiento=:nombreEstable", nativeQuery = true)
    public List<Bares[]> buscarPorNombre(@Param("nombreEstable") String nombreEstable);
    @Modifying
    @Query(value= "update establecimientos e set e.nombre_establecimiento=:nombreEstable where e.id_establecimientos=:id", nativeQuery=true)
    public Integer actualizarNombre(@Param("nombreEstable") String nombreEstable, @Param("id") Integer id);
}
