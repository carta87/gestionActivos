package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.CityDto;
import java.util.List;
import java.util.Optional;

public interface ICityRepository {
    List<CityDto> getAllCity();
    Optional<CityDto> getCity(int id);
    CityDto saveCity(CityDto city);
    void deleteCity(int cityId);
}
