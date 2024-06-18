package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.PositionDto;
import com.grupo.empresa.gestion_activos.domain.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("area")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AreaController {

    private final PositionService positionService;

    @GetMapping("findByAll")
    public ResponseEntity<List<PositionDto>> getAllPosition() {return new ResponseEntity<>(positionService.getAllPosition(), HttpStatus.OK) ; }

    @GetMapping("findById")
    public ResponseEntity<PositionDto> getPosition(@RequestParam("id") int id){
        return positionService.getPosition(id)
                .map(position -> new ResponseEntity<>(position, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<PositionDto> savePosition(@RequestBody PositionDto position){
        return new ResponseEntity<>(positionService.savePosition(position), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> deletePosition(@RequestParam("id") int positionId) {
        return positionService.deletePosition(positionId) ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
