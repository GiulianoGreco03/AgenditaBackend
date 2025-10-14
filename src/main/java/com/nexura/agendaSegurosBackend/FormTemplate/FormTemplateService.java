package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateDTO;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextfieldTemplateMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormTemplateService {

    private final FormTemplateRepository formTemplateRepository;
    private final FormTemplateMapper formTemplateMapper;
    private final TextfieldTemplateMapper textfieldTemplateMapper;
    private final CheckboxTemplateMapper checkboxTemplateMapper;
    private final SelectTemplateMapper selectTemplateMapper;

    public FormTemplateService(FormTemplateRepository formTemplateRepository, FormTemplateMapper formTemplateMapper, TextfieldTemplateMapper textfieldTemplateMapper, CheckboxTemplateMapper checkboxTemplateMapper, SelectTemplateMapper selectTemplateMapper) {
        this.formTemplateRepository = formTemplateRepository;
        this.formTemplateMapper = formTemplateMapper;
        this.textfieldTemplateMapper = textfieldTemplateMapper;
        this.checkboxTemplateMapper = checkboxTemplateMapper;
        this.selectTemplateMapper = selectTemplateMapper;
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

    public FormTemplateDTO updateFormTemplete(Long id, FormTemplateDTO formTemplate) {
        Optional<FormTemplateEntity> plantillaOptional = formTemplateRepository.findById(id);

        if(plantillaOptional.isEmpty()) throw new TemplateNotFoundException("No se encontro esa plantilla");

        FormTemplateEntity plantilla = plantillaOptional.get();

        System.out.println(plantilla.title + plantilla.id);
        if(formTemplate.title() != null){
            plantilla.setTitle(formTemplate.title());
        }
       if(formTemplate.textFields() != null){
           List<TextFieldTemplateEntity> updatedTextFields = formTemplate.textFields().stream().map(t ->{
               TextFieldTemplateEntity textField = textfieldTemplateMapper.toEntity(t);
               textField.setFormTemplate(plantilla);
               return textField;
           }).collect(Collectors.toList());

           plantilla.setTextFields(updatedTextFields);
       }

        if(formTemplate.checkboxes() != null){
            List<CheckboxTemplateEntity> updatedCheckboxes = formTemplate.checkboxes().stream().map(c -> {
                CheckboxTemplateEntity checkbox = checkboxTemplateMapper.toEntity(c);
                checkbox.setFormTemplate(plantilla);
                return checkbox;
            }).collect(Collectors.toList());
            plantilla.setCheckboxes(updatedCheckboxes);
        }

        if(formTemplate.selects() != null){
            List<SelectTemplateEntity> updatedSelects = formTemplate.selects().stream().map(s -> {
                SelectTemplateEntity select = selectTemplateMapper.toEntity(s);
                select.setFormTemplate(plantilla);
                return select;
            }).collect(Collectors.toList());
            plantilla.setSelects(updatedSelects);
        }
        formTemplateRepository.save(plantilla);
        return formTemplate;
    }

    public void deleteFormTemplate(Long id){
        formTemplateRepository.deleteById(id);
    }
}
