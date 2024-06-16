package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.ActiveDto;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IActiveRepository extends IAbstractRepository<ActiveDto, Integer> {
    Optional<List<ActiveDto>> getActiveByType(String type);
    Optional<List<ActiveDto>> getActiveBySerial(String serial);
    Optional<List<ActiveDto>> getActiveByDate(Date date);

}
