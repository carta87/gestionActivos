package com.grupo.empresa.gestion_activos.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class ActiveDto {

    private int id;
    private String name;
    private String description;
    private String type;
    private String serial;
    private String numberInsideInventory;
    private String weight;
    private String tall;
    private String length;
    private String width;
    private int idEmployee;
    private int idPosition;
    private int valueActive;
    private Date  datePurchuse;
    private PositionDto positionDto;
}