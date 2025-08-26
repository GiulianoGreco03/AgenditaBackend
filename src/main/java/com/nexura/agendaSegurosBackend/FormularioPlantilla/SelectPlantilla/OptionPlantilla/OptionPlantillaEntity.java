package com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.OptionPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.SelectPlantillaEntity;
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
public class OptionPlantillaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opcion;

    @ManyToOne
    @JoinColumn(name = "select_plantilla_id", nullable = false, updatable = false)
    private SelectPlantillaEntity selectPlantilla;
}
