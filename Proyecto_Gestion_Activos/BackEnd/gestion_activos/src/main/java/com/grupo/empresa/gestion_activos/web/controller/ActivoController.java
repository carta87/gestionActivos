package com.grupo.empresa.gestion_activos.web.controller;

import com.grupo.empresa.gestion_activos.domain.dto.ActiveDto;
import com.grupo.empresa.gestion_activos.domain.service.ActiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/activos")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActivoController {

    private final ActiveService activeService;

    @GetMapping("getAll")
    public ResponseEntity<List<ActiveDto>> getAllActive() {return new ResponseEntity<>(activeService.getAllActive(), HttpStatus.OK); }

    @GetMapping("findById")
    public ResponseEntity<ActiveDto> getActive(@RequestParam("id") int id){
        return activeService.getActive(id)
                .map(active -> new ResponseEntity<>(active, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("save")
    public ResponseEntity<ActiveDto> saveActive(@RequestBody ActiveDto active){
        return new ResponseEntity<>(activeService.saveActive(active),  HttpStatus.CREATED);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteActive(@RequestParam("id") int activeId) {
        return activeService.deleteActive(activeId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("findBytipo")
    public ResponseEntity<List<ActiveDto>> getActiveByType(@RequestParam("type") String type) {
        return activeService.getActiveByType(type)
                .map(activo -> new ResponseEntity<>(activo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("findBySerial")
    public ResponseEntity<List<ActiveDto>> getActiveBySerial(@RequestParam("serial") String serial){
        return activeService.getActiveBySerial(serial)
                .map(activo -> new ResponseEntity<>(activo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("findByfechaCompra")
    public ResponseEntity<List<ActiveDto>> getActiveByDate (@RequestParam("date") String dateImput){

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
             date = format.parse(dateImput);
            log.info(date.toString());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return activeService.getActiveByDate(date)
                .map(activo -> new ResponseEntity<>(activo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
