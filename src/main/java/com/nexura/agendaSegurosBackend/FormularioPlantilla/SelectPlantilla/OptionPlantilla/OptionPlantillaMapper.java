package com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.OptionPlantilla;

import org.springframework.stereotype.Component;

@Component
public class OptionPlantillaMapper {

    public OptionPlantillaDTO toDTO(OptionPlantillaEntity entity){
        return new OptionPlantillaDTO(entity.getOpcion());
    }

    public OptionPlantillaEntity toEntity(OptionPlantillaDTO dto){
        OptionPlantillaEntity entity = new OptionPlantillaEntity();
        entity.setOpcion(dto.opcion());
        return entity;
    }
}
