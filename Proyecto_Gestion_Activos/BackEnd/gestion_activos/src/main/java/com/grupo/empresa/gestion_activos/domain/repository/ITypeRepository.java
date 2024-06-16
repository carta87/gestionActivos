package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.MaterialOfficeDto;
import java.util.List;
import java.util.Optional;

public interface ITypeRepository {
    List<MaterialOfficeDto> getAllType();
    Optional<MaterialOfficeDto> getType(int id);
    MaterialOfficeDto saveType(MaterialOfficeDto type);
    void deleteType(int typeId);
}
