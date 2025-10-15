package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateCreateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateCreateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateCreateDTO;

import java.util.List;

public record FormTemplateCreateDTO(
        String title,
        List<TextFieldTemplateCreateDTO> textFields,
        List<CheckboxTemplateCreateDTO> checkboxes,
        List<SelectTemplateCreateDTO> selects
) {
}
