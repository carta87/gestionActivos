package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.EmployedDto;
import com.grupo.empresa.gestion_activos.domain.repository.IEmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeService {

    private final IEmployeRepository iEmployeRepository;

    public List<EmployedDto> getAllPerson(){return iEmployeRepository.findAll();}

    public Optional<EmployedDto> getEmploye(int id){
        return iEmployeRepository.findById(id); }

    public EmployedDto savePerson(EmployedDto person){
        return iEmployeRepository.update(person);}

    public boolean deletePerson(int personaId){
        return getEmploye(personaId).map(person ->{
           iEmployeRepository.deleteById(personaId);
           return true;
        }).orElse(false);
    }
}
