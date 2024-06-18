package com.grupo.empresa.gestion_activos.domain.repository;

import org.springframework.http.ResponseEntity;
import java.util.Map;

public interface IUserService {

    ResponseEntity<String> singUp(Map<String,String> requestMap);
    ResponseEntity<String> login(Map<String, String> requesMap);
}
