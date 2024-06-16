package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.EmployedDto;
import com.grupo.empresa.gestion_activos.domain.repository.IEmployeRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.EmpleadoRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.EmpleadoEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EnpleadoServiceImpl implements IEmployeRepository {

    private final EmployeeMapper employeeMapper;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<EmployedDto> findAll() {
        return employeeMapper.mapListDto((List<EmpleadoEntity>) empleadoRepository.findAll());
    }

    @Override
    public Optional<EmployedDto> findById(Integer id) {
        return empleadoRepository.findById(id).map(employeeMapper::mapDto);
    }

    @Override
    public EmployedDto update(EmployedDto person) {
        return employeeMapper.mapDto(empleadoRepository.save(employeeMapper.mapEntity(person)));
    }

    @Override
    public void deleteById(Integer entityId) {
        empleadoRepository.deleteById(entityId);
    }
}
