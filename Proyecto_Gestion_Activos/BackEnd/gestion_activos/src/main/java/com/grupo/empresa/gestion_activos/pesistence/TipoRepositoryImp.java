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
public class TipoRepositoryImp implements ITypeRepository {

    private final TypeMapper typeMapper;
    private final TipoRepository tipoRepository;

    @Override
    public List<MaterialOfficeDto> findAll() {
        return typeMapper.mapListDto((List<MaterialOficinaEntity>) tipoRepository.findAll());
    }

    @Override
    public Optional<MaterialOfficeDto> findById(Integer id) {
        return tipoRepository.findById(id).map(typeMapper::mapDto);
    }

    @Override
    public MaterialOfficeDto update(MaterialOfficeDto type) {
        return typeMapper.mapDto(tipoRepository.save(typeMapper.mapEntity(type)));
    }

    @Override
    public void deleteById(Integer typeId) {
        tipoRepository.deleteById(typeId);
    }
}
