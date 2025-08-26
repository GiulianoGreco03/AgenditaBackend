package com.nexura.agendaSegurosBackend.FormularioPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.CampoTextoPlantilla.CampoTextoPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.CheckboxPlantilla.CheckboxPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.SelectPlantillaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@ToString(exclude = {"camposTexto", "checkboxes", "selects"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Formulario_plantilla")
public class FormularioPlantillaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;

    @OneToMany(mappedBy = "formularioPlantilla", cascade = CascadeType.ALL)
    List<CampoTextoPlantillaEntity> camposTexto = new ArrayList<>();

    @OneToMany(mappedBy = "formularioPlantilla", cascade = CascadeType.ALL)
    List<CheckboxPlantillaEntity> checkboxes = new ArrayList<>();

    @OneToMany(mappedBy = "formularioPlantilla", cascade = CascadeType.ALL)
    List<SelectPlantillaEntity> selects = new ArrayList<>();
}
