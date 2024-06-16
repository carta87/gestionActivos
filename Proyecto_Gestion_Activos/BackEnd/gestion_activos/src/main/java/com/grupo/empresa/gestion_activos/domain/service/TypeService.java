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
        return iTypeRepository.findAll();}

    public Optional<MaterialOfficeDto> getType(Integer id) {
        return iTypeRepository.findById(id);
    }

    public MaterialOfficeDto saveType(MaterialOfficeDto type) {
        return iTypeRepository.update(type);
    }

    public boolean deleteType(int tipoId) {
        return getType(tipoId).map(type -> {
            iTypeRepository.deleteById(tipoId);
            return true;
        }).orElse(false);
    }
}
