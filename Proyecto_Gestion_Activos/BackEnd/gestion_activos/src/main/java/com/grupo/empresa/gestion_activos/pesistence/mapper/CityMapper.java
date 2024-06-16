package com.grupo.empresa.gestion_activos.pesistence.mapper;

import com.grupo.empresa.gestion_activos.domain.dto.CityDto;
import com.grupo.empresa.gestion_activos.pesistence.entity.CiudadEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "nombreCiudad", target = "nameCity")
    CityDto mapToDto(CiudadEntity ciudad);
    List<CityDto> mapListDto(List<CiudadEntity> ciudads);

    @InheritInverseConfiguration
    CiudadEntity mapEntity(CityDto city);
}
