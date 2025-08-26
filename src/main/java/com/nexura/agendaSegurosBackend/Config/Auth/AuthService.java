package com.nexura.agendaSegurosBackend.Config.Auth;

import com.nexura.agendaSegurosBackend.Config.Auth.JWT.JwtService;
import com.nexura.agendaSegurosBackend.User.EmailNotFoundException;
import com.nexura.agendaSegurosBackend.User.Roles;
import com.nexura.agendaSegurosBackend.User.UserEntity;
import com.nexura.agendaSegurosBackend.User.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.contrasenia()));
        UserDetails userDetails = userRepository.findByEmail(request.email()).orElseThrow(()->new EmailNotFoundException("Este usuario no se encuentra registrado"));
        String token = jwtService.getToken(userDetails);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest request) {
        UserEntity usuario = new UserEntity();
        usuario.setEmail(request.email());
        usuario.setPassword(passwordEncoder.encode(request.contrasenia()));
        usuario.setRole(Roles.ADMINISTRADOR);

        userRepository.save(usuario);

        return new AuthResponse(jwtService.getToken(usuario));
    }
}
