package com.nexura.agendaSegurosBackend.FormularioPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.CampoTextoPlantilla.CampoTextoPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.CampoTextoPlantilla.CampoTextoPlantillaMapper;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.CheckboxPlantilla.CheckboxPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.CheckboxPlantilla.CheckboxPlantillaMapper;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.SelectPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.SelectPlantillaMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormularioPlantillaMapper {

    private final CampoTextoPlantillaMapper campoTextoPlantillaMapper;
    private final SelectPlantillaMapper selectPlantillaMapper;
    private final CheckboxPlantillaMapper checkboxPlantillaMapper;

    public FormularioPlantillaMapper(CampoTextoPlantillaMapper campoTextoPlantillaMapper, SelectPlantillaMapper selectPlantillaMapper, CheckboxPlantillaMapper checkboxPlantillaMapper){
        this.campoTextoPlantillaMapper = campoTextoPlantillaMapper;
        this.selectPlantillaMapper = selectPlantillaMapper;
        this.checkboxPlantillaMapper = checkboxPlantillaMapper;
    }

    public FormularioPlantillaDTO toDTO(FormularioPlantillaEntity entity){
        return new FormularioPlantillaDTO(entity.getNombre(),
                entity.camposTexto.stream().map(campoTextoPlantillaMapper::toDTO).toList(),
                entity.checkboxes.stream().map(checkboxPlantillaMapper::toDTO).toList(),
                entity.selects.stream().map(selectPlantillaMapper::toDTO).toList());
    }

    public FormularioPlantillaEntity toEntity(FormularioPlantillaDTO dto){
        FormularioPlantillaEntity formulario = FormularioPlantillaEntity.builder()
                .nombre(dto.nombre()).build();

        List<CampoTextoPlantillaEntity> campos = dto.camposTexto().stream().map(
                campo -> CampoTextoPlantillaEntity.builder()
                        .titulo(campo.titulo())
                        .orden(campo.orden())
                        .formularioPlantilla(formulario)
                        .build()
        ).toList();

        List<CheckboxPlantillaEntity> checkboxes = dto.checkboxes().stream().map(
                checkbox -> CheckboxPlantillaEntity.builder()
                        .titulo(checkbox.titulo())
                        .orden(checkbox.orden())
                        .formularioPlantilla(formulario)
                        .build()
        ).toList();

        List<SelectPlantillaEntity> selects = dto.selects().stream().map(selectPlantillaMapper::toEntity).toList();

        for(SelectPlantillaEntity select : selects){
            select.setFormularioPlantilla(formulario);
        }

        formulario.setCheckboxes(checkboxes);
        formulario.setSelects(selects);
        formulario.setCamposTexto(campos);

        return formulario;
    }
}
