package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.PossessionDto;
import java.util.List;
import java.util.Optional;

public interface IFurnitureRepository {
    List<PossessionDto> getAllFurniture();
    Optional<PossessionDto> getFurniture(int id);
    PossessionDto saveFurniture(PossessionDto furniture);
    void deleteFurniture(int furnitureId);
}
