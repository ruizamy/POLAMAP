package com.ecommerce.backend.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="promocion")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromocion;
    @Column(name = "nombre")
    private  String nombrePromocion;
    @Column(name = "tipo")
    private  Integer tipo;



    @OneToMany(mappedBy = "promocion", cascade = CascadeType.ALL)
    List<Boletas> boletas;
}
