package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.CityDto;
import com.grupo.empresa.gestion_activos.domain.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("ciudad")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CiudadController {

    private final CityService cityService;


    @GetMapping("findByAll")
    public ResponseEntity<List<CityDto>> getAllCity() {return  new ResponseEntity<>(cityService.getAllCity(), HttpStatus.OK); }


    @GetMapping("findById")
    public ResponseEntity<CityDto> getCity(@RequestParam("id") int id){
        return cityService.getCity(id)
                .map(city -> new ResponseEntity<>(city, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<CityDto> saveCity(@RequestBody CityDto city){
        return new ResponseEntity<>(cityService.saveCity(city), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> deleteCity(@RequestParam("id") int cityId) {
        return  cityService.deleteCity(cityId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
