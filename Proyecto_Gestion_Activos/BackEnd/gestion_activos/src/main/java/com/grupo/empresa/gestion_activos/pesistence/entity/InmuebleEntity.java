package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "inmueble")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id_activo")
public class InmuebleEntity extends ActivoEntity {

    private String ubicacion;

}
