package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.PositionDto;
import com.grupo.empresa.gestion_activos.domain.repository.IPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionService   {

    private final IPositionRepository iPositionRepository;

    public List<PositionDto> getAllPosition(){return iPositionRepository.findAll();}

    public Optional<PositionDto> getPosition(int id){
        return iPositionRepository.findById(id);}

    public PositionDto savePosition(PositionDto position) {
        return iPositionRepository.update(position);
    }

    public boolean deletePosition(int positionId) {
        return getPosition(positionId).map(position -> {
            iPositionRepository.deleteById(positionId);
            return true;
        }).orElse(false);
    }
}
