package com.nexura.agendaSegurosBackend.FormularioPlantilla;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormularioPlantillaRepository extends JpaRepository<FormularioPlantillaEntity, Long> {

}
