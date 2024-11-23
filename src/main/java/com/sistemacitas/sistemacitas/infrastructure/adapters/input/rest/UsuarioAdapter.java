package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.UsuarioServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.UsuarioRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.AuthenticationRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.UsuarioRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.AuthenticationResponse;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.UsuarioResponse;
import com.sistemacitas.sistemacitas.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioAdapter {
    private final UsuarioServicePort servicePort;
    private final UsuarioRestMapper restMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/v1/api")
    public ResponseEntity<UsuarioResponse> guardar(@RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toUsuarioResponse(servicePort.register(restMapper.toUsuario(request))));
    }

    @PostMapping("/v1/api/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/logout")
    public boolean logout() {
        return servicePort.logout();
    }
}
