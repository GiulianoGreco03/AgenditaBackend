package com.nexura.agendaSegurosBackend.Client;

import com.nexura.agendaSegurosBackend.Config.Auth.JWT.JwtService;
import com.nexura.agendaSegurosBackend.Address.AddressEntity;
import com.nexura.agendaSegurosBackend.Address.AddressRepository;
import com.nexura.agendaSegurosBackend.User.EmailNotFoundException;
import com.nexura.agendaSegurosBackend.User.UserEntity;
import com.nexura.agendaSegurosBackend.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository AddressRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final ClienteMapper clienteMapper;

    public ClientService(ClientRepository clientRepository,
                         AddressRepository addressRepository,
                         JwtService jwtService,
                         UserRepository userRepository,
                         ClienteMapper clienteMapper) {
        this.clientRepository = clientRepository;
        this.AddressRepository = addressRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClientDTO crearCliente(ClientDTO clientDTO) {

        AddressEntity direccion =  AddressEntity.builder()
                .calle(clientDTO.address().calle())
                .provincia(clientDTO.address().provincia())
                .localidad(clientDTO.address().localidad()).build();

        AddressRepository.save(direccion);

        UserEntity usuario = userRepository.findByEmail(clientDTO.userEmail()).orElseThrow(()-> new EmailNotFoundException("Error al asociar al usuario"));

        ClientEntity cliente = ClientEntity.builder()
                .name(clientDTO.name())
                .lastName(clientDTO.lastName())
                .dni(clientDTO.dni())
                .birthDate(clientDTO.birthDate())
                .email(clientDTO.email())
                .phone(clientDTO.phone())
                .address(direccion)
                .user(usuario)
                .build();

        clientRepository.save(cliente);

        return clientDTO;

    }

    public List<ClientDTO> getClientes(){
        return clientRepository.findAll().stream().map(clienteMapper::toDto).collect(Collectors.toList());
    }

    public List<ClientDTO> getClientesByUsuarioID(Long usuarioID){
        return clientRepository.findByUserId(usuarioID).stream().map(clienteMapper::toDto).collect(Collectors.toList());
    }
}
