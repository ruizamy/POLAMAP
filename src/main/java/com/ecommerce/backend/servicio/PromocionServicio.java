package com.ecommerce.backend.servicio;

import com.ecommerce.backend.modelo.Boletas;
import com.ecommerce.backend.modelo.Promocion;
import com.ecommerce.backend.repositorio.BoletasRepositorio;
import com.ecommerce.backend.repositorio.PromocionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromocionServicio {
    PromocionRepositorio promocionRepositorio;
    public PromocionServicio(PromocionRepositorio promocionRepositorio) {
        this.promocionRepositorio = promocionRepositorio;
    }
    public Object crearPromocion(Promocion promocion){
        return promocionRepositorio.save(promocion);
    }

    public Object buscarPromocionPorId(Integer idPromocion){
        return promocionRepositorio.findById(idPromocion);
    }

    public List<Promocion[]> buscarPromocionPorNombre(String nombrePromocion){
        return promocionRepositorio.buscarPorNombre(nombrePromocion);
    }
    public List<Promocion> buscarTodo(){
        return promocionRepositorio.findAll();
    }

    public void borrarPromocion(Integer idBoletas){
        promocionRepositorio.deleteById(idBoletas);
    }

    public void actualizarPromocion(Integer idPromocion, Promocion promocion)  {

        Promocion pro = promocionRepositorio.getById(idPromocion);
        pro.setNombrePromocion(promocion.getNombrePromocion());
        pro.setTipo(promocion.getTipo());

        promocionRepositorio.save(pro);
    }
}
