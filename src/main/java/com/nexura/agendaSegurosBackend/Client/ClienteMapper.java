package com.nexura.agendaSegurosBackend.Client;

import com.nexura.agendaSegurosBackend.Address.AddressMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    private final AddressMapper addressMapper;

    public ClienteMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public ClientDTO toDto(ClientEntity clientEntity) {
        return new ClientDTO(
                clientEntity.getName(),
                clientEntity.getLastName(),
                clientEntity.getDni(),
                clientEntity.getPhone(),
                clientEntity.getEmail(),
                clientEntity.getBirthDate(),
                addressMapper.toDto(clientEntity.getAddress()),
                clientEntity.getUser().getEmail()
        );
    }
}
