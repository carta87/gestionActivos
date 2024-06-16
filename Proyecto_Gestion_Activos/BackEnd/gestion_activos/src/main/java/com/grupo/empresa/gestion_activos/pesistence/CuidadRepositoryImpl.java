package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.CityDto;
import com.grupo.empresa.gestion_activos.domain.repository.ICityRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.CiudadRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.CiudadEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CuidadRepositoryImpl implements ICityRepository {

    private final CityMapper cityMapper;
    private final CiudadRepository ciudadRepository;

    @Override
    public List<CityDto> findAll() {
        return cityMapper.mapListDto((List<CiudadEntity>) ciudadRepository.findAll());
    }

    @Override
    public Optional<CityDto> findById(Integer id) {
        return ciudadRepository.findById(id).map(cityMapper::mapToDto);
    }

    @Override
    public CityDto update(CityDto city) {
        return cityMapper.mapToDto(ciudadRepository.save(cityMapper.mapEntity(city)));
    }

    @Override
    public void deleteById(Integer entityId) {
        ciudadRepository.deleteById(entityId);
    }
}
