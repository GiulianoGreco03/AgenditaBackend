package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate;

import org.springframework.stereotype.Component;

@Component
public class OptionTemplateMapper {

    public OptionTemplateDTO toDTO(OptionTemplateEntity entity){
        return new OptionTemplateDTO(entity.getOptionValue());
    }

    public OptionTemplateEntity toEntity(OptionTemplateDTO dto){
        OptionTemplateEntity entity = new OptionTemplateEntity();
        entity.setOptionValue(dto.optionValue());
        return entity;
    }
}
