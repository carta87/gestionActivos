package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.PossessionDto;
import com.grupo.empresa.gestion_activos.domain.repository.IFurnitureRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.InMuebleRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.InmuebleEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.FurnitureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MuebleRepositoryImpl implements IFurnitureRepository {

    private final FurnitureMapper furnitureMapper;
    private final InMuebleRepository inMuebleRepository;

    @Override
    public List<PossessionDto> findAll() {
        return furnitureMapper.mapListDto((List<InmuebleEntity>) inMuebleRepository.findAll());
    }

    @Override
    public Optional<PossessionDto> findById(Integer id) {
        return inMuebleRepository.findById(id).map(furnitureMapper::mapDto);
    }

    @Override
    public PossessionDto update(PossessionDto furniture) {
        return furnitureMapper.mapDto(inMuebleRepository.save(furnitureMapper.mapEntity(furniture)));
    }

    @Override
    public void deleteById(Integer furnitureId) {
        inMuebleRepository.deleteById(furnitureId);
    }
}
