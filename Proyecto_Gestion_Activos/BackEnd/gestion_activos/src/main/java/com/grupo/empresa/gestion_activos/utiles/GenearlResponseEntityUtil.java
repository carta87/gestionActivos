package com.grupo.empresa.gestion_activos.utiles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenearlResponseEntityUtil {

    public static ResponseEntity<String> getResponseEntity(String mesage, HttpStatus httpStatus){
        return new ResponseEntity<>("Mensaje: " + mesage, httpStatus );
    }
}
