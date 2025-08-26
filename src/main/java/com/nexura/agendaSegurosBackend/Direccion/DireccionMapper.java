package com.nexura.agendaSegurosBackend.Direccion;

import org.springframework.stereotype.Component;

@Component
public class DireccionMapper {
    public DireccionDTO toDto(DireccionEntity direccionEntity) {
        return new DireccionDTO(direccionEntity.getCalle(),
                direccionEntity.getNumero(),
                direccionEntity.getLocalidad(),
                direccionEntity.getProvincia());
    }

    public DireccionEntity toEntity(DireccionDTO direccionDTO) {
        return DireccionEntity.builder().calle(direccionDTO.calle())
                .numero(direccionDTO.numero())
                .localidad(direccionDTO.localidad())
                .provincia(direccionDTO.provincia())
                .build();
    }
}
