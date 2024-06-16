package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.MaterialOfficeDto;
import com.grupo.empresa.gestion_activos.domain.repository.ITypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final ITypeRepository iTypeRepository;

    public List<MaterialOfficeDto> getAllType() {
        return iTypeRepository.getAllType();}

    public Optional<MaterialOfficeDto> getType(int id) {
        return iTypeRepository.getType(id);
    }

    public MaterialOfficeDto saveType(MaterialOfficeDto type) {
        return iTypeRepository.saveType(type);
    }

    public boolean deleteType(int tipoId) {
        return getType(tipoId).map(type -> {
            iTypeRepository.deleteType(tipoId);
            return true;
        }).orElse(false);
    }
}
