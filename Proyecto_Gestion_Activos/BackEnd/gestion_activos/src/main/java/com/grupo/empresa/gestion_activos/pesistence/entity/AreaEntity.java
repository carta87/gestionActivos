package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "area")
@Getter
@Setter
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToOne( cascade = {CascadeType.ALL} )
    @JoinColumn(name ="ciudad", referencedColumnName = "id")
    private CiudadEntity ciudadEntity;

    @OneToMany(mappedBy = "areaEntity")
    private List<ActivoEntity> activoEntity = new ArrayList<>();
    
}

