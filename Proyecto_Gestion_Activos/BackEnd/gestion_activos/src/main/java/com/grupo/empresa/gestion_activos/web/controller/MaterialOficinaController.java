package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.MaterialOfficeDto;
import com.grupo.empresa.gestion_activos.domain.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("materialOficina")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MaterialOficinaController {

    private final TypeService typeService;

    @GetMapping("findByAll")
    public ResponseEntity<List<MaterialOfficeDto>> getAllType() {return new ResponseEntity<>(typeService.getAllType(), HttpStatus.OK); }


    @GetMapping("findById")
    public ResponseEntity<MaterialOfficeDto> getRegister(@RequestParam("id") int id){
        return typeService.getType(id)
                .map(materialOffice -> new ResponseEntity<>(materialOffice, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<MaterialOfficeDto> saveRegister(@RequestBody MaterialOfficeDto type){
        return new ResponseEntity<>(typeService.saveType(type), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> delete(@RequestParam("id") int typeId) {
        return typeService.deleteType(typeId) ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
