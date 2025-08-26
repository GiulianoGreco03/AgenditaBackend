package com.nexura.agendaSegurosBackend.FormularioPlantilla;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formularios_plantilla")
public class FormularioPlantillaController {
    private final FormularioPlantillaService formularioPlantillaService;

    public FormularioPlantillaController(FormularioPlantillaService formularioPlantillaService) {
        this.formularioPlantillaService = formularioPlantillaService;
    }

    @GetMapping
    public List<FormularioPlantillaDTO> getFormulariosPlantilla(){
        return formularioPlantillaService.getFormulariosPlantilla();
    }

    @PostMapping
    public FormularioPlantillaDTO postFormularioPlantilla(@RequestBody FormularioPlantillaDTO formularioPlantilla){
        return formularioPlantillaService.postFormularioPlantilla(formularioPlantilla);
    }
}
