package com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.OptionPlantilla.OptionPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.OptionPlantilla.OptionPlantillaMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectPlantillaMapper {

    private final OptionPlantillaMapper optionPlantillaMapper;

    public SelectPlantillaMapper(OptionPlantillaMapper optionPlantillaMapper) {
        this.optionPlantillaMapper = optionPlantillaMapper;
    }

    public SelectPlantillaDTO toDTO(SelectPlantillaEntity entity){
        return new SelectPlantillaDTO(entity.getTitulo(),
                entity.getOptions().stream().map(optionPlantillaMapper::toDTO).toList()
                );
    }

    public SelectPlantillaEntity toEntity(SelectPlantillaDTO dto){
        SelectPlantillaEntity select = SelectPlantillaEntity.builder()
                .titulo(dto.titulo())
                .build();

        List<OptionPlantillaEntity> options = dto.options().stream().map(option ->
                        OptionPlantillaEntity.builder()
                                .opcion(option.opcion())
                                .selectPlantilla(select)
                                .build()).toList();

        select.setOptions(options);

        return select;
    }
}
