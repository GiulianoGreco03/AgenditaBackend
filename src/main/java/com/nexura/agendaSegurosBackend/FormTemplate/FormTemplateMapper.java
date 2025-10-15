package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextfieldTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TextfieldTemplateMapper.class, CheckboxTemplateMapper.class, SelectTemplateMapper.class})
public interface FormTemplateMapper {



    public FormTemplateResponseDTO toDTO(FormTemplateEntity entity);

    public FormTemplateEntity toEntity(FormTemplateCreateDTO dto);
}
