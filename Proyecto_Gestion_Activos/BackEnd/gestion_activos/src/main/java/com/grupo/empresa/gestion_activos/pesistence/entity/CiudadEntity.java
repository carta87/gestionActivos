package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "ciudad")
@Getter
@Setter
public class CiudadEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

}