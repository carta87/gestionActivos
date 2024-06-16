package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.PositionDto;
import java.util.List;
import java.util.Optional;

public interface IPositionRepository {
    List<PositionDto> getAllPosition();
    Optional<PositionDto> getPosition(int id);
    PositionDto savePosition(PositionDto position);
    void deletePosition(int positionId);
}
