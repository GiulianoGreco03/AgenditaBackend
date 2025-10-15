package com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CheckboxTemplateMapper {

    public CheckboxTemplateResponseDTO toDTO(CheckboxTemplateEntity entity);

    public CheckboxTemplateEntity toEntity(CheckboxTemplateCreateDTO dto);
}
