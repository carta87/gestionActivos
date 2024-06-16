package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.MaterialOfficeDto;
import com.grupo.empresa.gestion_activos.domain.repository.ITypeRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.TipoRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.MaterialOficinaEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.TypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TipoServiceImp implements ITypeRepository {

    private final TypeMapper typeMapper;
    private final TipoRepository tipoRepository;

    @Override
    public List<MaterialOfficeDto> getAllType() {
        return typeMapper.mapListDto((List<MaterialOficinaEntity>) tipoRepository.findAll());
    }

    @Override
    public Optional<MaterialOfficeDto> getType(int id) {
        return tipoRepository.findById(id).map(typeMapper::mapDto);
    }

    @Override
    public MaterialOfficeDto saveType(MaterialOfficeDto type) {
        return typeMapper.mapDto(tipoRepository.save(typeMapper.mapEntity(type)));
    }

    @Override
    public void deleteType(int typeId) {
        tipoRepository.deleteById(typeId);
    }
}
