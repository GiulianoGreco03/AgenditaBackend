package com.nexura.agendaSegurosBackend.FormTemplate.CheckboxTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.FormTemplateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checkbox_templates")
public class CheckboxTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "`order`")
    private int order;

    @ManyToOne
    @JoinColumn(name = "form_templates_id", nullable = false, updatable = false)
    private FormTemplateEntity formTemplate;
}
