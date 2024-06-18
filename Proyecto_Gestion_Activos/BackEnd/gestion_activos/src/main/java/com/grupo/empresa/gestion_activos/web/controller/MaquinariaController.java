package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.MachineDto;
import com.grupo.empresa.gestion_activos.domain.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("maquinaria")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MaquinariaController {

    private final MachineService machineService;

    @GetMapping("findByAll")
    public ResponseEntity<List<MachineDto>> getAllPerson() {return new ResponseEntity<>(machineService.getAllMachine(), HttpStatus.OK); }


    @GetMapping("findById")
    public ResponseEntity<MachineDto> getPerson(@RequestParam("id") int id){
        return machineService.getMachine(id)
                .map(machine -> new ResponseEntity<>(machine, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<MachineDto> savePerson(@RequestBody MachineDto machine){
        return new ResponseEntity<>(machineService.saveMachine(machine), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> deletePerson(@RequestParam("id") int machineId) {
        return machineService.deleteMachine(machineId) ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
