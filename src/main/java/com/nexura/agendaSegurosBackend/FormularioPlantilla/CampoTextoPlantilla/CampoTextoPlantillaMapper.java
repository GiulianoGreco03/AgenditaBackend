package com.nexura.agendaSegurosBackend.FormularioPlantilla.CampoTextoPlantilla;

import org.springframework.stereotype.Component;

@Component
public class CampoTextoPlantillaMapper {
    public CampoTextoPlantillaDTO toDTO(CampoTextoPlantillaEntity entity){
        return new CampoTextoPlantillaDTO(entity.getTitulo(), entity.getOrden());
    }

    public CampoTextoPlantillaEntity toEntity(CampoTextoPlantillaDTO dto){
        return CampoTextoPlantillaEntity.builder()
                .titulo(dto.titulo())
                .orden(dto.orden())
                .build();
    }
}
