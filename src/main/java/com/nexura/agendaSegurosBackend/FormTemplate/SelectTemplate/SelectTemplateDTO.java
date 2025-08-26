package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateDTO;

import java.util.List;

public record SelectTemplateDTO(String title,
                                List<OptionTemplateDTO> options) {
}
