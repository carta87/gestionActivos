package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.PossessionDto;
import com.grupo.empresa.gestion_activos.domain.repository.IFurnitureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FurnitureService {

    private final IFurnitureRepository iFurnitureRepository;

    public List<PossessionDto> getAllFurniture(){
        return iFurnitureRepository.findAll();}

    public Optional<PossessionDto> getFurniture(int id){
        return iFurnitureRepository.findById(id);}

    public PossessionDto saveFurniture(PossessionDto furniture){
        return iFurnitureRepository.update(furniture);}

    public boolean deleteFurniture(int furnitureId){
        return getFurniture(furnitureId).map(furniture ->{
            iFurnitureRepository.deleteById(furnitureId);
            return true;
        }).orElse(false);
    }
}
