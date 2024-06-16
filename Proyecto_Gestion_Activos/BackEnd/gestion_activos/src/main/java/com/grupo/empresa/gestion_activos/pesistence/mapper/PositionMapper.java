package com.grupo.empresa.gestion_activos.pesistence.mapper;

import com.grupo.empresa.gestion_activos.domain.dto.PositionDto;
import com.grupo.empresa.gestion_activos.pesistence.entity.AreaEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class, ActiveMapper.class }  )
public interface  PositionMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "namePosition"),
            @Mapping(source = "ciudadEntity", target = "cityDto"),
            @Mapping(source = "activoEntity", target = "activeDto"),

    })
    PositionDto mapDto(AreaEntity area);
    List<PositionDto> mapListDto(List<AreaEntity> areas);

    @InheritInverseConfiguration
   // @Mapping(target = "activoEntity", ignore = true) //si se qioere eliminar propiedad
    AreaEntity mapEntity(PositionDto position);
}