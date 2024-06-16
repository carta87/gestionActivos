package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.PositionDto;
import com.grupo.empresa.gestion_activos.domain.repository.IPositionRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.CargoRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.AreaEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.PositionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CargoRepositoryImp implements IPositionRepository {

    private final PositionMapper positionMapper;
    private final CargoRepository cargoRepository;

    @Override
    public List<PositionDto> findAll() {
        return positionMapper.mapListDto((List<AreaEntity>) cargoRepository.findAll());
    }

    @Override
    public Optional<PositionDto> findById(Integer id) {
        return cargoRepository.findById(id).map(positionMapper::mapDto);
    }

    @Override
    public PositionDto update(PositionDto position) {
        return positionMapper.mapDto(cargoRepository.save(positionMapper.mapEntity(position)));
    }

    @Override
    public void deleteById(Integer positionId) {
        cargoRepository.deleteById(positionId);
    }
}
