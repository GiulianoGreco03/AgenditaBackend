package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.SelectTemplateEntity;
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
@Table
public class OptionTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionValue;

    @ManyToOne
    @JoinColumn(name = "select_templates_id", nullable = false, updatable = false)
    private SelectTemplateEntity selectTemplate;
}
