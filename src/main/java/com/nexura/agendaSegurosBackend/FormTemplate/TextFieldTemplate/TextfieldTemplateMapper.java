package com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate;

import org.springframework.stereotype.Component;

@Component
public class TextfieldTemplateMapper {
    public TextFieldTemplateDTO toDTO(TextFieldTemplateEntity entity){
        return new TextFieldTemplateDTO(entity.getTitle(), entity.getOrder());
    }

    public TextFieldTemplateEntity toEntity(TextFieldTemplateDTO dto){
        return TextFieldTemplateEntity.builder()
                .title(dto.title())
                .order(dto.order())
                .build();
    }
}
