package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectTemplateMapper {

    private final OptionTemplateMapper optionTemplateMapper;

    public SelectTemplateMapper(OptionTemplateMapper optionTemplateMapper) {
        this.optionTemplateMapper = optionTemplateMapper;
    }

    public SelectTemplateDTO toDTO(SelectTemplateEntity entity){
        return new SelectTemplateDTO(entity.getTitle(),
                entity.getOptions().stream().map(optionTemplateMapper::toDTO).toList()
                );
    }

    public SelectTemplateEntity toEntity(SelectTemplateDTO dto){
        SelectTemplateEntity select = SelectTemplateEntity.builder()
                .title(dto.title())
                .build();

        List<OptionTemplateEntity> options = dto.options().stream().map(option ->
                        OptionTemplateEntity.builder()
                                .optionValue(option.optionValue() )
                                .selectTemplate(select)
                                .build()).toList();

        select.setOptions(options);

        return select;
    }
}
