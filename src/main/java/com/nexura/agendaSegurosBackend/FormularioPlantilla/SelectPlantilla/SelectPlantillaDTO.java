package com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla;

import com.nexura.agendaSegurosBackend.FormularioPlantilla.SelectPlantilla.OptionPlantilla.OptionPlantillaDTO;

import java.util.List;

public record SelectPlantillaDTO(String titulo,
                                 List<OptionPlantillaDTO> options) {
}
