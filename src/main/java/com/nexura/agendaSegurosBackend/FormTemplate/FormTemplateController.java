package com.nexura.agendaSegurosBackend.FormTemplate;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formularios-plantilla")
public class FormTemplateController {
    private final FormTemplateService formTemplateService;

    public FormTemplateController(FormTemplateService formTemplateService) {
        this.formTemplateService = formTemplateService;
    }

    @GetMapping
    public List<FormTemplateResponseDTO> getFormTemplates(){
        return formTemplateService.getFormTemplates();
    }

    @PostMapping
    public FormTemplateResponseDTO postFormTemplate(@RequestBody FormTemplateCreateDTO FormTemplate){
        return formTemplateService.postFormTemplate(FormTemplate);
    }

    @PutMapping("/{id}")
    public FormTemplateResponseDTO putFormTemplate(@PathVariable Long id, @RequestBody FormTemplateCreateDTO FormTemplate){
        return formTemplateService.updateFormTemplete(id, FormTemplate);
    }
}
