package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.CityDto;
import com.grupo.empresa.gestion_activos.domain.repository.ICityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService  {

    private final ICityRepository iCityRepository;

    public List<CityDto> getAllCity() {
        return iCityRepository.getAllCity();
    }

    public Optional<CityDto> getCity(int id) {
        return iCityRepository.getCity(id);}

    public CityDto saveCity(CityDto city) {
        return iCityRepository.saveCity(city);}

    public boolean deleteCity(int cityId) {
        return getCity(cityId).map(city ->{
            iCityRepository.deleteCity(cityId);
            return true;
        }).orElse(false);
    }
}
