package com.grupo.empresa.gestion_activos.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MachineDto extends ActiveDto {

    private String brand;

}
