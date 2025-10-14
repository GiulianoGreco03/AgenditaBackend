package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextfieldTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormTemplateMapper {

    private final TextfieldTemplateMapper textfieldTemplateMapper;
    private final SelectTemplateMapper selectTemplateMapper;
    private final CheckboxTemplateMapper checkboxTemplateMapper;

    public FormTemplateMapper(TextfieldTemplateMapper textfieldTemplateMapper, SelectTemplateMapper selectTemplateMapper, CheckboxTemplateMapper checkboxTemplateMapper){
        this.textfieldTemplateMapper = textfieldTemplateMapper;
        this.selectTemplateMapper = selectTemplateMapper;
        this.checkboxTemplateMapper = checkboxTemplateMapper;
    }

    public FormTemplateDTO toDTO(FormTemplateEntity entity){
        return new FormTemplateDTO(entity.getId(),
                entity.getTitle(),
                entity.textFields.stream().map(textfieldTemplateMapper::toDTO).toList(),
                entity.checkboxes.stream().map(checkboxTemplateMapper::toDTO).toList(),
                entity.selects.stream().map(selectTemplateMapper::toDTO).toList());
    }

    public FormTemplateEntity toEntity(FormTemplateDTO dto){
        FormTemplateEntity formulario = FormTemplateEntity.builder()
                .title(dto.title()).build();

        List<TextFieldTemplateEntity> campos = dto.textFields().stream().map(
                campo -> TextFieldTemplateEntity.builder()
                        .title(campo.title())
                        .order(campo.order())
                        .formTemplate(formulario)
                        .build()
        ).toList();

        List<CheckboxTemplateEntity> checkboxes = dto.checkboxes().stream().map(
                checkbox -> CheckboxTemplateEntity.builder()
                        .title(checkbox.title())
                        .order(checkbox.order())
                        .formTemplate(formulario)
                        .build()
        ).toList();

        List<SelectTemplateEntity> selects = dto.selects().stream().map(selectTemplateMapper::toEntity).toList();

        for(SelectTemplateEntity select : selects){
            select.setFormTemplate(formulario);
        }

        formulario.setCheckboxes(checkboxes);
        formulario.setSelects(selects);
        formulario.setTextFields(campos);

        return formulario;
    }
}
