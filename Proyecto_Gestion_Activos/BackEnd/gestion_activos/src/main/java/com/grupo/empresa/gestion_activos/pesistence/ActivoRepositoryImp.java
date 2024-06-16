package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.ActiveDto;
import com.grupo.empresa.gestion_activos.domain.repository.IActiveRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.ActivoEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.ActiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ActivoRepositoryImp implements IActiveRepository {

    private final ActiveMapper activeMapper;
    private final com.grupo.empresa.gestion_activos.pesistence.crud.ActivoRepository activoRepository;

    @Override
    public List<ActiveDto> findAll() {
        return activeMapper.mapListDto((List<ActivoEntity>)activoRepository.findAll());
    }

    @Override
    public Optional<ActiveDto> findById(Integer id) {
        return activoRepository.findById(id).map(activeMapper::mapDto);
    }

    @Override
    public ActiveDto update(ActiveDto active) {
        return activeMapper.mapDto(activoRepository.save(activeMapper.mapEntity(active)));
    }

    @Override
    public void deleteById(Integer entityId) {
        activoRepository.deleteById(entityId);
    }


    @Override
    public Optional<List<ActiveDto>> getActiveByType(String type){
        return Optional.of(activeMapper.mapListDto(activoRepository.findByTipoEquals(type)));
    }

    @Override
    public Optional<List<ActiveDto>> getActiveBySerial(String serial) {
        return Optional.of(activeMapper.mapListDto(activoRepository.findBySerial(serial)));
    }

    @Override
    public Optional<List<ActiveDto>> getActiveByDate(Date date) {
        return Optional.of(activeMapper.mapListDto(activoRepository.findAllByFechaCompra(date)));
    }

    /*public List<Active> getActiveByType(int type) {
        String ahora = ""+type;
        //System.out.println("esta es la varaible por path " +type);
        //List<Activo> activos = (List<Activo>) activoCRUDRepository.findAll();
        //return activeMapper.toListActive(activos);
        if(type == 1){
            ahora = "Maquinaria";
            //"vas a mostrar Maquinaria"
            System.out.println("desde la consola 1");
            //List<Active> activos = activoCRUDRepository.findByType(type);
            //return activos;
            List<Activo> activos = (List<Activo>) activoCRUDRepository.findAll();
            return activeMapper.toListActive(activos);

        }else{
            ahora = "Muebles";
            //"vas a mostrar Muebles"
            System.out.println("desde la consola 2");
            List<Activo> activos = (List<Activo>) activoCRUDRepository.findAll();
            return activeMapper.toListActive(activos);
        }
       */
}