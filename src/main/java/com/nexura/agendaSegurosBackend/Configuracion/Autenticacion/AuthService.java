package com.nexura.agendaSegurosBackend.Configuracion.Autenticacion;

import com.nexura.agendaSegurosBackend.Configuracion.Autenticacion.JWT.JwtService;
import com.nexura.agendaSegurosBackend.Usuario.EmailNoEncontradoException;
import com.nexura.agendaSegurosBackend.Usuario.Roles;
import com.nexura.agendaSegurosBackend.Usuario.UsuarioEntity;
import com.nexura.agendaSegurosBackend.Usuario.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UsuarioRepository usuarioRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.contrasenia()));
        UserDetails userDetails = usuarioRepository.findByEmail(request.email()).orElseThrow(()->new EmailNoEncontradoException("Este usuario no se encuentra registrado"));
        String token = jwtService.getToken(userDetails);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest request) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(request.email());
        usuario.setContrasenia(passwordEncoder.encode(request.contrasenia()));
        usuario.setRole(Roles.ADMINISTRADOR);

        usuarioRepository.save(usuario);

        return new AuthResponse(jwtService.getToken(usuario));
    }
}
