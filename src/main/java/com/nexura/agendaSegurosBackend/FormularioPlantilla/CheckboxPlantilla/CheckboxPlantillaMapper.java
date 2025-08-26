package com.nexura.agendaSegurosBackend.FormularioPlantilla.CheckboxPlantilla;

import org.springframework.stereotype.Component;

@Component
public class CheckboxPlantillaMapper {
    public CheckboxPlantillaDTO toDTO(CheckboxPlantillaEntity entity){
        return new CheckboxPlantillaDTO(entity.getTitulo(), entity.getOrden());
    }

    public CheckboxPlantillaEntity toEntity(CheckboxPlantillaDTO dto){
        return CheckboxPlantillaEntity.builder()
                .titulo(dto.titulo())
                .orden(dto.orden())
                .build();
    }
}
