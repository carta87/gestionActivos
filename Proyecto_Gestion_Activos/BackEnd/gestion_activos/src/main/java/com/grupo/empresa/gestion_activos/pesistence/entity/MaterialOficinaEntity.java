package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name= "material_oficina")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id_activo")
public class MaterialOficinaEntity extends ActivoEntity {

    private String estado;
}
