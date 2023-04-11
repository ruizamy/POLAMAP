package com.ecommerce.backend.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="boletas")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Boletas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idBoletas;
        @Column(name = "nombreBoletas")
        private  String nombreBoleta;
        @Column(name = "descripcionBoleta")
        private  String descripcionBoleta;
        @Column(name = "cantidad")
        private  Integer cantidad;
        @Column(name = "precio")
        private  Float precio;
        @Column(name = "urlImgBoleta")
        private  String imgUrlBoleta;

        @Column(name = "fechaBoleta")
        @JsonFormat(pattern = "yyyyMMdd")
        private Date fechaBoleta;
        @JsonIgnore
        @JoinColumn(name = "id_establecimientos")
        @ManyToOne
        Bares bares;
        @JsonIgnore
        @JoinColumn(name = "id_promocion")
        @ManyToOne
        Promocion promocion;
    }

