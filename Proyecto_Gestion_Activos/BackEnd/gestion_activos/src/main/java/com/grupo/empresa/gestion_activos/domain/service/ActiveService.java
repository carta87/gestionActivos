package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.ActiveDto;
import com.grupo.empresa.gestion_activos.domain.repository.IActiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActiveService {

    private final IActiveRepository iActiveRepository;

    public List<ActiveDto> getAllActive() {
        return iActiveRepository.getAllActive();
    }

    public Optional<ActiveDto> getActive(int id) {
        return iActiveRepository.getActive(id);}

    public ActiveDto saveActive(ActiveDto active) {
        return iActiveRepository.saveActive(active);
    }

    public boolean deleteActive(int activeId) {
        return getActive(activeId).map(active -> {
            iActiveRepository.deleteActive(activeId);
            return true;
        }).orElse(false);
    }

    public Optional<List<ActiveDto>> getActiveByType(String type){
        return iActiveRepository.getActiveByType(type);
    }
    
    public  Optional<List<ActiveDto>> getActiveBySerial(String serial){
        return  iActiveRepository.getActiveBySerial(serial);
    }
    
    public Optional<List<ActiveDto>> getActiveByDate(Date date){
        return  iActiveRepository.getActiveByDate(date);
    }

}
