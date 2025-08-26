package com.nexura.agendaSegurosBackend.Cliente;

import com.nexura.agendaSegurosBackend.Configuracion.Autenticacion.JWT.JwtService;
import com.nexura.agendaSegurosBackend.Direccion.DireccionEntity;
import com.nexura.agendaSegurosBackend.Direccion.DireccionRepository;
import com.nexura.agendaSegurosBackend.Usuario.EmailNoEncontradoException;
import com.nexura.agendaSegurosBackend.Usuario.UsuarioEntity;
import com.nexura.agendaSegurosBackend.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final DireccionRepository DireccionRepository;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository,
                          DireccionRepository direccionRepository,
                          JwtService jwtService,
                          UsuarioRepository usuarioRepository,
                          ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.DireccionRepository = direccionRepository;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        DireccionEntity direccion =  DireccionEntity.builder()
                .calle(clienteDTO.direccion().calle())
                .numero(clienteDTO.direccion().numero())
                .provincia(clienteDTO.direccion().provincia())
                .localidad(clienteDTO.direccion().localidad()).build();

        DireccionRepository.save(direccion);

        UsuarioEntity usuario = usuarioRepository.findByEmail(clienteDTO.emailUsuario()).orElseThrow(()-> new EmailNoEncontradoException("Error al asociar al usuario"));

        ClienteEntity cliente = ClienteEntity.builder()
                .nombre(clienteDTO.nombre())
                .apellido(clienteDTO.apellido())
                .dni(clienteDTO.dni())
                .fechaNacimiento(clienteDTO.fechaNacimiento())
                .email(clienteDTO.email())
                .telefono(clienteDTO.telefono())
                .direccion(direccion)
                .usuario(usuario)
                .build();

        clienteRepository.save(cliente);

        return clienteDTO;

    }

    public List<ClienteDTO> getClientes(){
        return clienteRepository.findAll().stream().map(clienteMapper::toDto).collect(Collectors.toList());
    }

    public List<ClienteDTO> getClientesByUsuarioID(Long usuarioID){
        return clienteRepository.findByUsuarioId(usuarioID).stream().map(clienteMapper::toDto).collect(Collectors.toList());
    }
}
