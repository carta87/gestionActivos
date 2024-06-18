package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.EmployedDto;
import com.grupo.empresa.gestion_activos.domain.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("empleados")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EmpleadoController {

    private final EmployeService employeService;

    @GetMapping("findByAll")
    public ResponseEntity<List<EmployedDto>> getAllPerson() {return new ResponseEntity<>(employeService.getAllPerson(), HttpStatus.OK); }


    @GetMapping("findById")
    public ResponseEntity<EmployedDto> getPerson(@RequestParam("este") int id){
        return employeService.getEmploye(id)
                .map(person ->  new ResponseEntity<>(person, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<EmployedDto> savePerson(@RequestBody EmployedDto person){
        return new ResponseEntity<>(employeService.savePerson(person), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> deletePerson(@RequestParam("id") int personId) {
        return employeService.deletePerson(personId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
