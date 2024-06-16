package com.grupo.empresa.gestion_activos.pesistence.crud;

import com.grupo.empresa.gestion_activos.pesistence.entity.ActivoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActivoRepository extends CrudRepository<ActivoEntity, Integer> {
    List<ActivoEntity> findByTipo(String tipo);

    List<ActivoEntity> findByTipoEquals(String tipo);

    List<ActivoEntity> findBySerial(String serial);

    List<ActivoEntity> findAllByFechaCompra(Date date);

    List<ActivoEntity> findByFechaCompraEquals(Date date);

    @Query (value= "SELECT * FROM activo WHERE activo.tipo LIKE %:filtro%", nativeQuery = true)
    List<ActivoEntity> encontrarTipo(@Param("filtro") String tipo);

}