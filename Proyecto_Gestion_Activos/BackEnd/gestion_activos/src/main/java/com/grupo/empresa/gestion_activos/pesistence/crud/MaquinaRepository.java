package com.grupo.empresa.gestion_activos.pesistence.crud;

import com.grupo.empresa.gestion_activos.pesistence.entity.MaquinariaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends CrudRepository<MaquinariaEntity, Integer> {
}
