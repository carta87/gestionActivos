package com.grupo.empresa.gestion_activos.web.controller;


import com.grupo.empresa.gestion_activos.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController()
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/singup")
    public ResponseEntity<String> registrarUsuario(@RequestBody Map<String, String> requestMap){
         return userService.singUp(requestMap);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap){
        return userService.login(requestMap);
    }
}
