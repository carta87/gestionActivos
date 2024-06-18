package com.grupo.empresa.gestion_activos.domain.service;


import com.grupo.empresa.gestion_activos.pesistence.crud.EmpleadoRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.EmpleadoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerDetailsService implements UserDetailsService {

    private final EmpleadoRepository empleadoRepository;

    @Getter
    private EmpleadoEntity empleadoEntity;


    public UserDetails loadUserByUsername2(String email) throws UsernameNotFoundException {
        log.info("Dentro de loadUserByUsername con el email {}", email);
        empleadoEntity = empleadoRepository.findByEmail(email);
        if(!Objects.isNull(empleadoEntity)){
            return new org.springframework.security.core.userdetails.User(empleadoEntity.getEmail(), empleadoEntity.getPassword(), new ArrayList<>());
        }else {
            throw new  UsernameNotFoundException("Usuario no encontrado");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        empleadoEntity = empleadoRepository.findByEmail(email);

        //String[] roles = userDetail.getRoles().stream().map(UserRoleEntity::getRole).toArray(String[]::new);
        return org.springframework.security.core.userdetails.User.builder()
                .username(empleadoEntity.getEmail())
                .password(empleadoEntity.getPassword())
                .authorities(grantedAuthority(Collections.singleton(empleadoEntity.getRole()).toArray(new String[0])))//.roles(roles)
                .build();
    }

    /*
    TODO forma de uso en SecurityConfig:
     .requestMatchers("/api/orders/**").hasAnyAuthority("random_order")
     */
    private String[] getAuthorities(String role){
        if ("ADMIN".equalsIgnoreCase(role) || "OTRO_PERFIL".equalsIgnoreCase(role) ){
            return new String[]{ "ESTABLECE_NOMBRE_AUTHORITIES"};
        }
        return new String[] {};
    }

    private List<GrantedAuthority> grantedAuthority(String[] roles){
        List<GrantedAuthority> authoritiess = new ArrayList<>(roles.length);
        for (String role: roles){
            authoritiess.add(new SimpleGrantedAuthority("ROLE_" +role));
            for (String authority: getAuthorities(role)){
                authoritiess.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authoritiess;
    }
}
