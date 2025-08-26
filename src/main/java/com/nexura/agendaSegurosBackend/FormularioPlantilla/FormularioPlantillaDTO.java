package com.nexura.agendaSegurosBackend.FormularioPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.CampoTextoPlantilla.CampoTextoPlantillaDTO;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.CheckboxPlantilla.CheckboxPlantillaDTO;
import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.SelectPlantillaDTO;

import java.util.List;

public record FormularioPlantillaDTO(
        String nombre,
        List<CampoTextoPlantillaDTO> camposTexto,
        List<CheckboxPlantillaDTO> checkboxes,
        List<SelectPlantillaDTO> selects
) {
}
