package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateMapper;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateMapper;
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

    public List<FormTemplateResponseDTO> getFormTemplates(){
        List<FormTemplateEntity> formularios = formTemplateRepository.findAll();
        return formularios.stream().map(formTemplateMapper::toDTO).toList();
    }

    public FormTemplateEntity getFormTemplate(Long id){
        return formTemplateRepository.getReferenceById(id);
    }

    public FormTemplateResponseDTO postFormTemplate(FormTemplateCreateDTO FormTemplate){
        FormTemplateEntity plantilla = formTemplateMapper.toEntity(FormTemplate);

        System.out.println(plantilla.title );
        plantilla.getCheckboxes().forEach(checkbox -> {checkbox.setFormTemplate(plantilla);});

        plantilla.getSelects().forEach(select -> {select.setFormTemplate(plantilla);
            select.getOptions().forEach(option -> option.setSelectTemplate(select));});

        plantilla.getTextFields().forEach(textField -> {textField.setFormTemplate(plantilla);});

        formTemplateRepository.save(plantilla);

        return formTemplateMapper.toDTO(plantilla);
    }

    public FormTemplateResponseDTO updateFormTemplete(Long id, FormTemplateCreateDTO formTemplate) {
        Optional<FormTemplateEntity> plantillaOptional = formTemplateRepository.findById(id);

        if(plantillaOptional.isEmpty()) throw new TemplateNotFoundException("No se encontro esa plantilla");

        FormTemplateEntity plantilla = plantillaOptional.get();

        if(formTemplate.title() != null && !formTemplate.title().isEmpty()){
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
                select.getOptions().forEach(option -> option.setSelectTemplate(select));
                select.setFormTemplate(plantilla);
                return select;
            }).collect(Collectors.toList());
            plantilla.setSelects(updatedSelects);
        }
        formTemplateRepository.save(plantilla);
        return formTemplateMapper.toDTO(plantilla);
    }

    public void deleteFormTemplate(Long id){
        formTemplateRepository.deleteById(id);
    }
}
