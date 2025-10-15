package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OptionTemplateMapper.class})
public interface SelectTemplateMapper {

    public SelectTemplateResponseDTO toDTO(SelectTemplateEntity entity);

    public SelectTemplateEntity toEntity(SelectTemplateCreateDTO dto);
}
