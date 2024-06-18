package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.constantes.GeneralConstantes;
import com.grupo.empresa.gestion_activos.domain.repository.IUserService;
import com.grupo.empresa.gestion_activos.pesistence.crud.EmpleadoRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.EmpleadoEntity;
import com.grupo.empresa.gestion_activos.utiles.GenearlResponseEntityUtil;
import com.grupo.empresa.gestion_activos.utiles.jwToken.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final EmpleadoRepository empleadoRepository;
    private final CustomerDetailsService customerDetailsService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<String> singUp(Map<String, String> requestMap) {
        log.info("registro interno de un usuario {}", requestMap);
        if(validateSingUpMap(requestMap)){
            EmpleadoEntity user = empleadoRepository.findByEmail(requestMap.get("email"));
            if (Objects.isNull(user)){
                empleadoRepository.save(getUsetFromMap(requestMap));
                return GenearlResponseEntityUtil.getResponseEntity("usuario registrado con exito", HttpStatus.CREATED);
            }else {
                return GenearlResponseEntityUtil.getResponseEntity("El usuario con ese email ya existe", HttpStatus.BAD_REQUEST);
            }
        }else {
            return GenearlResponseEntityUtil.getResponseEntity(GeneralConstantes.DATOS_INVALIDADOS, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requesMap) {
        log.info("Dentro de login");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requesMap.get("email"), requesMap.get("password")));

        if(authentication.isAuthenticated() && customerDetailsService.getEmpleadoEntity().getStatus().equalsIgnoreCase("true")){
            return new ResponseEntity<>("{token: "+ jwtUtil.generateToken(
                    customerDetailsService.getEmpleadoEntity().getEmail(), customerDetailsService.getEmpleadoEntity().getRole()) + "}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{mensaje: credenciales incorectas}", HttpStatus.BAD_REQUEST);
    }

    private boolean validateSingUpMap(Map<String, String> requestMap){
        return requestMap.containsKey("nombre") && requestMap.containsKey("numeroConctacto") &&
                requestMap.containsKey("email") && requestMap.containsKey("password");
    }

    private EmpleadoEntity getUsetFromMap(Map<String, String> requestMap){
        EmpleadoEntity user = new EmpleadoEntity();
        user.setNombre(requestMap.get("nombre"));
        user.setNumeroConctacto(requestMap.get("numeroConctacto"));
        user.setEmail(requestMap.get("email"));
        user.setPassword((requestMap.get("password")));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}
