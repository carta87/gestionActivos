package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.EmployedDto;
import java.util.List;
import java.util.Optional;

public interface IEmployeRepository {
    List<EmployedDto> getAllEmploye();
    Optional<EmployedDto> getEmploye(int id);
    EmployedDto saveEmploye(EmployedDto person);
    void deleteEmploye(int personId);
}
