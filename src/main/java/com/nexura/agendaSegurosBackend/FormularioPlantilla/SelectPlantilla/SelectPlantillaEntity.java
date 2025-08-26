package com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.FormularioPlantillaEntity;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.OptionPlantilla.OptionPlantillaEntity;
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
public class SelectPlantillaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(mappedBy = "selectPlantilla", cascade = CascadeType.ALL)
    List<OptionPlantillaEntity> options;

    @ManyToOne
    @JoinColumn(name = "formulario_plantilla_id", nullable = false, updatable = false)
    private FormularioPlantillaEntity formularioPlantilla;

}
