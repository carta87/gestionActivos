package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.EmployedDto;
import com.grupo.empresa.gestion_activos.domain.repository.IEmployeRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.EmpleadoRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.EmpleadoEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.EmpleadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EnpleadoServiceImpl implements IEmployeRepository {

    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<EmployedDto> getAllEmploye() {
        return empleadoMapper.mapListDto((List<EmpleadoEntity>) empleadoRepository.findAll());
    }

    @Override
    public Optional<EmployedDto> getEmploye(int id) {
        return empleadoRepository.findById(id).map(empleadoMapper::mapDto);
    }

    @Override
    public EmployedDto saveEmploye(EmployedDto person) {
        return empleadoMapper.mapDto(empleadoRepository.save(empleadoMapper.mapEntity(person)));
    }

    @Override
    public void deleteEmploye(int personId) {
        empleadoRepository.deleteById(personId);
    }
}
