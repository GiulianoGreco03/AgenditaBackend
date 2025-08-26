package com.nexura.agendaSegurosBackend.FormTemplate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormTemplateService {

    private final FormTemplateRepository formTemplateRepository;
    private final FormTemplateMapper formTemplateMapper;

    public FormTemplateService(FormTemplateRepository formTemplateRepository, FormTemplateMapper formTemplateMapper) {
        this.formTemplateRepository = formTemplateRepository;
        this.formTemplateMapper = formTemplateMapper;
    }

    public List<FormTemplateDTO> getFormTemplates(){
        List<FormTemplateEntity> formularios = formTemplateRepository.findAll();
        return formularios.stream().map(formTemplateMapper::toDTO).toList();
    }

    public FormTemplateEntity getFormTemplate(Long id){
        return formTemplateRepository.getReferenceById(id);
    }

    public FormTemplateDTO postFormTemplate(FormTemplateDTO FormTemplate){
        FormTemplateEntity plantilla = formTemplateMapper.toEntity(FormTemplate);
        formTemplateRepository.save(plantilla);
        return FormTemplate;
    }
}
