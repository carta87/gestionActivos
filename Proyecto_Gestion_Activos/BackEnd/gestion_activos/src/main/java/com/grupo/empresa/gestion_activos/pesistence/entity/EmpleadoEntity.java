package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleado")
@Getter
@Setter
public class EmpleadoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer identificacion;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<ActivoEntity> activo = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private AreaEntity areaEntity;

    @Column(name = "numero_conctacto")
    private String numeroConctacto;

    private String email;

    private String password;

    private String status;

    private String role;
}
