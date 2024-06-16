package com.grupo.empresa.gestion_activos.pesistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity (name= "activo")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class ActivoEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String tipo;
    @Column (name= "num_serial")
    private String serial;
    @Column(name = "num_inventario")
    private String numeroInternoInventarioActivo;
    private String peso;
    private String alto;
    private String largo;
    private String ancho;
    @Column(name = "id_area")
    private Integer idArea;
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Column(name = "valor_compra")
    private Integer valorActivo;
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private AreaEntity areaEntity;

}
