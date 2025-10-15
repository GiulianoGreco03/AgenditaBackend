package com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TextfieldTemplateMapper {
    public TextFieldTemplateResponseDTO toDTO(TextFieldTemplateEntity entity);

    public TextFieldTemplateEntity toEntity(TextFieldTemplateCreateDTO dto);
}
