package com.nexura.agendaSegurosBackend.FormularioPlantilla.CampoTextoPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.FormularioPlantillaEntity;
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
@Table(name = "Campos_texto_plantilla")
public class CampoTextoPlantillaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private int orden;

    @ManyToOne
    @JoinColumn(name = "formulario_plantilla_id", nullable = false, updatable = false)
    private FormularioPlantillaEntity formularioPlantilla;
}
