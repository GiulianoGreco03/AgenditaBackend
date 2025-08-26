package com.nexura.agendaSegurosBackend.FormularioPlantilla;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class FormularioPlantillaService {

    private final FormularioPlantillaRepository formularioPlantillaRepository;
    private final FormularioPlantillaMapper formularioPlantillaMapper;

    public FormularioPlantillaService(FormularioPlantillaRepository formularioPlantillaRepository, FormularioPlantillaMapper formularioPlantillaMapper) {
        this.formularioPlantillaRepository = formularioPlantillaRepository;
        this.formularioPlantillaMapper = formularioPlantillaMapper;
    }

    public List<FormularioPlantillaDTO> getFormulariosPlantilla(){
        List<FormularioPlantillaEntity> formularios = formularioPlantillaRepository.findAll();
        return formularios.stream().map(formularioPlantillaMapper::toDTO).toList();
    }

    public FormularioPlantillaEntity getFormularioPlantilla(Long id){
        return formularioPlantillaRepository.getReferenceById(id);
    }

    public FormularioPlantillaDTO postFormularioPlantilla(FormularioPlantillaDTO formularioPlantilla){
        FormularioPlantillaEntity plantilla = formularioPlantillaMapper.toEntity(formularioPlantilla);
        System.out.println(plantilla);
        formularioPlantillaRepository.save(plantilla);
        return formularioPlantilla;
    }
}
