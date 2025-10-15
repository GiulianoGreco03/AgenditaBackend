package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OptionTemplateMapper {

     OptionTemplateResponseDTO toDTO(OptionTemplateEntity entity);

     OptionTemplateEntity toEntity(OptionTemplateCreateDTO dto);
}
