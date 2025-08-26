package com.nexura.agendaSegurosBackend.FormTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.TextFieldTemplate.TextFieldTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate.CheckboxTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class FormTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @OneToMany(mappedBy = "formTemplate", cascade = CascadeType.ALL)
    List<TextFieldTemplateEntity> textFields = new ArrayList<>();

    @OneToMany(mappedBy = "formTemplate", cascade = CascadeType.ALL)
    List<CheckboxTemplateEntity> checkboxes = new ArrayList<>();

    @OneToMany(mappedBy = "formTemplate", cascade = CascadeType.ALL)
    List<SelectTemplateEntity> selects = new ArrayList<>();
}
