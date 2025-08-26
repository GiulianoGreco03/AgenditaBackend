package com.nexura.agendaSegurosBackend.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    public List<ClienteEntity> findByUsuarioId(Long id);

}
