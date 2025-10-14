package com.nexura.agendaSegurosBackend.FormTemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormTemplateRepository extends JpaRepository<FormTemplateEntity, Long> {

    Optional<FormTemplateEntity> findById(Long id);

}
