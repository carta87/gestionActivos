package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.MachineDto;
import java.util.List;
import java.util.Optional;

public interface IMachineRepository {
    List<MachineDto> getAllMachine();
    Optional<MachineDto> getMachine(int id);
    MachineDto saveMachine(MachineDto machine);
    void deleteMachine(int machineId);
}
