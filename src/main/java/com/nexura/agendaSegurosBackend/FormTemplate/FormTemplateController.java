package com.nexura.agendaSegurosBackend.FormTemplate;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formularios_plantilla")
public class FormTemplateController {
    private final FormTemplateService formTemplateService;

    public FormTemplateController(FormTemplateService formTemplateService) {
        this.formTemplateService = formTemplateService;
    }

    @GetMapping
    public List<FormTemplateDTO> getFormTemplates(){
        return formTemplateService.getFormTemplates();
    }

    @PostMapping
    public FormTemplateDTO postFormTemplate(@RequestBody FormTemplateDTO FormTemplate){
        return formTemplateService.postFormTemplate(FormTemplate);
    }
}
