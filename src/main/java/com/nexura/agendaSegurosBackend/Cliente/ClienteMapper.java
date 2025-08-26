package com.nexura.agendaSegurosBackend.Cliente;

import com.nexura.agendaSegurosBackend.Direccion.DireccionMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    private final DireccionMapper direccionMapper;

    public ClienteMapper(DireccionMapper direccionMapper) {
        this.direccionMapper = direccionMapper;
    }

    public ClienteDTO toDto(ClienteEntity clienteEntity) {
        return new ClienteDTO(
                clienteEntity.getNombre(),
                clienteEntity.getApellido(),
                clienteEntity.getDni(),
                clienteEntity.getTelefono(),
                clienteEntity.getEmail(),
                clienteEntity.getFechaNacimiento(),
                direccionMapper.toDto(clienteEntity.getDireccion()),
                clienteEntity.getUsuario().getEmail()
        );
    }
}
