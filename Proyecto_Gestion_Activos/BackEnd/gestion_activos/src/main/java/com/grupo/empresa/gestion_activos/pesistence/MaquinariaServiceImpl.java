package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.MachineDto;
import com.grupo.empresa.gestion_activos.domain.repository.IMachineRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.MaquinaRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.MaquinariaEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.MachineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MaquinariaServiceImpl implements IMachineRepository {

    private final MachineMapper machineMapper;
    private final MaquinaRepository maquinaRepository;

    @Override
    public List<MachineDto> getAllMachine() {
        return machineMapper.mapListDto((List<MaquinariaEntity>) maquinaRepository.findAll());
    }

    @Override
    public Optional<MachineDto> getMachine(int id) {
        return maquinaRepository.findById(id).map(machineMapper::mapDto);
    }

    @Override
    public MachineDto saveMachine(MachineDto machine) {
        return machineMapper.mapDto(maquinaRepository.save(machineMapper.mapEntity(machine)));
    }

    @Override
    public void deleteMachine(int machineId) {
        maquinaRepository.deleteById(machineId);
    }
}
