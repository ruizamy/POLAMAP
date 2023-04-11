package com.ecommerce.backend.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="establecimientos")
public class Bares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstablecimientos;
    @Column(name = "nombreEstablecimiento")
    private  String nombreEstable;
    @Column(name = "descripcionEstablecimiento")
    private  String descripcionEstable;
    @Column(name = "oferta")
    private  String oferta;
    @Column(name = "urlImgEstablecimiento")
    private  String imgUrlEstable;

    @OneToMany(mappedBy = "bares", cascade = CascadeType.ALL)
    List<Boletas> boletas;

}
