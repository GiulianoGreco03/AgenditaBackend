package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateCreateDTO;

import java.util.List;

public record SelectTemplateResponseDTO(Long id,
                                        String title,
                                        List<OptionTemplateCreateDTO> options) {
}
