package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateCreateDTO;

import java.util.List;

public record SelectTemplateCreateDTO(String title,
                                      List<OptionTemplateCreateDTO> options) {
}
