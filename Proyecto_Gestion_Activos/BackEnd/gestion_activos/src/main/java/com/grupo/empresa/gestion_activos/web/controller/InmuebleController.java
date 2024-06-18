package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.PossessionDto;
import com.grupo.empresa.gestion_activos.domain.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("inmueble")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class InmuebleController {

    private final FurnitureService furnitureService;

    @GetMapping("findByAll")
    public ResponseEntity<List<PossessionDto>> getAllPerson() {return new ResponseEntity<>(furnitureService.getAllFurniture(), HttpStatus.OK); }


    @GetMapping("findById")
    public ResponseEntity<PossessionDto> getPerson(@RequestParam("id") int id){
        return furnitureService.getFurniture(id)
                .map(possession -> new ResponseEntity<>(possession, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<PossessionDto> savePerson(@RequestBody PossessionDto furniture){
        return new ResponseEntity<>(furnitureService.saveFurniture(furniture), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> deletePerson(@RequestParam("id") int furnitureId) {
        return furnitureService.deleteFurniture(furnitureId) ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}