package com.grupo.empresa.gestion_activos.domain.dto;

import lombok.Data;
import java.util.List;

@Data
public class PositionDto {

    private int id;
    private String namePosition;
    private CityDto cityDto;
    private List<ActiveDto> activeDto;
}
