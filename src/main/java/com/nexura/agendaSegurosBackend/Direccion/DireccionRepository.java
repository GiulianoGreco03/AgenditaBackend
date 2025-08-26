package com.nexura.agendaSegurosBackend.Direccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Long> {
    DireccionEntity findByClienteId(Long id);
}
