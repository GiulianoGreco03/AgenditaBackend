package com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate;

import com.nexura.agendaSegurosBackend.FormTemplate.FormTemplateEntity;
import com.nexura.agendaSegurosBackend.FormTemplate.SelectTemplate.OptionTemplate.OptionTemplateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class SelectTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "`order`")
    private int order;

    @OneToMany(mappedBy = "selectTemplate", cascade = CascadeType.ALL)
    List<OptionTemplateEntity> options;

    @ManyToOne
    @JoinColumn(name = "form_templates_id", nullable = false, updatable = false)
    private FormTemplateEntity formTemplate;

}
