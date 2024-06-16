package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "maquinaria")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id_activo")
public class MaquinariaEntity extends ActivoEntity {

    private String marca;
    
}