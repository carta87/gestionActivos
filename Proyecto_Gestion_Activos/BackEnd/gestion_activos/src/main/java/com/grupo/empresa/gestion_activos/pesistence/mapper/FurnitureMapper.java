package com.grupo.empresa.gestion_activos.pesistence.mapper;

import com.grupo.empresa.gestion_activos.domain.dto.PossessionDto;
import com.grupo.empresa.gestion_activos.pesistence.entity.InmuebleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring", uses = ActiveMapper.class)
public interface FurnitureMapper {
    @Mappings({
            @Mapping(source = "id", target = "id" ),
            @Mapping(source = "ubicacion", target = "location"),
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
            @Mapping(source = "areaEntity", target = "positionDto"),
            @Mapping(source = "idArea", target = "idPosition"),
            @Mapping(source = "idEmpleado", target = "idEmployee"),

    })
    PossessionDto mapDto(InmuebleEntity mueble);
    List<PossessionDto> mapListDto(List<InmuebleEntity> muebles);

    @InheritInverseConfiguration
    InmuebleEntity mapEntity(PossessionDto furniture);
}
