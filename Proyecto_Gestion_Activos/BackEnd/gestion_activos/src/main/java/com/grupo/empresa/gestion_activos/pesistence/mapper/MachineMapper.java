package com.grupo.empresa.gestion_activos.pesistence.mapper;

import com.grupo.empresa.gestion_activos.domain.dto.MachineDto;
import com.grupo.empresa.gestion_activos.pesistence.entity.MaquinariaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MachineMapper  {

    @Mappings({
            @Mapping(source = "id", target = "id" ),
            @Mapping(source = "marca", target = "brand"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "tipo", target = "type"),
            @Mapping(source = "serial", target = "serial"),
            @Mapping(source = "numeroInternoInventarioActivo", target = "numberInsideInventory"),
            @Mapping(source = "peso", target = "weight"),
            @Mapping(source = "alto", target = "tall"),
            @Mapping(source = "largo", target = "length"),
            @Mapping(source = "ancho", target = "width"),
            @Mapping(source = "valorActivo", target = "valueActive"),
            @Mapping(source = "fechaCompra", target = "datePurchuse"),
            @Mapping(source = "idArea", target = "idPosition"),
            @Mapping(source = "idEmpleado", target = "idEmployee"),
            @Mapping(source = "areaEntity", target = "positionDto"),

    })
    MachineDto mapDto(MaquinariaEntity maquinaria);
    List<MachineDto> mapListDto(List<MaquinariaEntity> maquinarias);

    @InheritInverseConfiguration
    MaquinariaEntity mapEntity(MachineDto machine);
}
