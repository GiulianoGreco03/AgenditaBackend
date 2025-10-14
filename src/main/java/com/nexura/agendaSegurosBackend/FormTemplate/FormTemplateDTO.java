package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateDTO;

import java.util.List;

public record FormTemplateDTO(
        Long id,
        String title,
        List<TextFieldTemplateDTO> textFields,
        List<CheckboxTemplateDTO> checkboxes,
        List<SelectTemplateDTO> selects
) {
}
