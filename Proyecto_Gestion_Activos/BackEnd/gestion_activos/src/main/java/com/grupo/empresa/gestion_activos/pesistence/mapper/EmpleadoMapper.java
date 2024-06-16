package com.grupo.empresa.gestion_activos.pesistence.mapper;

import com.grupo.empresa.gestion_activos.domain.dto.EmployedDto;
import com.grupo.empresa.gestion_activos.pesistence.entity.EmpleadoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "identificacion", target = "identification")
    EmployedDto mapDto(EmpleadoEntity persona);
    List<EmployedDto> mapListDto(List<EmpleadoEntity> personas);

    @InheritInverseConfiguration
    default EmpleadoEntity mapEntity(EmployedDto ignoredPerson) {
        return null;
    }
}
