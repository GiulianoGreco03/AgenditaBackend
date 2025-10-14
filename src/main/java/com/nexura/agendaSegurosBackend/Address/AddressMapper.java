package com.nexura.agendaSegurosBackend.Address;

import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO toDto(AddressEntity addressEntity) {
        return new AddressDTO(addressEntity.getCalle(),
                addressEntity.getLocalidad(),
                addressEntity.getProvincia());
    }

    public AddressEntity toEntity(AddressDTO addressDTO) {
        return AddressEntity.builder().calle(addressDTO.calle())
                .localidad(addressDTO.localidad())
                .provincia(addressDTO.provincia())
                .build();
    }
}
