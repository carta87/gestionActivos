package com.grupo.empresa.gestion_activos.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PossessionDto extends ActiveDto {

    private String location;
}