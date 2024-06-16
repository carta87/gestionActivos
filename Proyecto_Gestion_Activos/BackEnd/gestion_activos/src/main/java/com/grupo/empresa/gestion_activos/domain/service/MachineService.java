package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.MachineDto;
import com.grupo.empresa.gestion_activos.domain.repository.IMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MachineService {

    private final IMachineRepository iMachineRepository;

    public List<MachineDto> getAllMachine(){
        return iMachineRepository.findAll();}

    public Optional<MachineDto> getMachine(int id){
        return iMachineRepository.findById(id);}

    public MachineDto saveMachine(MachineDto machine){
        return iMachineRepository.update(machine);}

    public boolean deleteMachine(int machineId){
        return getMachine(machineId).map(machine -> {
            iMachineRepository.deleteById(machineId);
            return true;
        }).orElse(false);
    }
}
