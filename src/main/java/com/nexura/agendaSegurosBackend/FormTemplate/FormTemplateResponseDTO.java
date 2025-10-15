package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateCreateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateResponseDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateCreateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateResponseDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateCreateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateResponseDTO;

import java.util.List;

public record FormTemplateResponseDTO(Long id,
                                      String title,
                                      List<TextFieldTemplateResponseDTO> textFields,
                                      List<CheckboxTemplateResponseDTO> checkboxes,
                                      List<SelectTemplateResponseDTO> selects) {
}
