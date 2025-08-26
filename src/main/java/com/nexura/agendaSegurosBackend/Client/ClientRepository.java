package com.nexura.agendaSegurosBackend.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    public List<ClientEntity> findByUserId(Long id);

}
