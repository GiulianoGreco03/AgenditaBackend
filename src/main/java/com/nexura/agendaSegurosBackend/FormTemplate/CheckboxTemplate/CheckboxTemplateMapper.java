package com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate;

import org.springframework.stereotype.Component;

@Component
public class CheckboxTemplateMapper {
    public CheckboxTemplateDTO toDTO(CheckboxTemplateEntity entity){
        return new CheckboxTemplateDTO(entity.getTitle(), entity.getOrder());
    }

    public CheckboxTemplateEntity toEntity(CheckboxTemplateDTO dto){
        return CheckboxTemplateEntity.builder()
                .title(dto.title())
                .order(dto.order())
                .build();
    }
}
