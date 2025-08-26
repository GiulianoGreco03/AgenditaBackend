package com.nexura.agendaSegurosBackend.FormTemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormTemplateRepository extends JpaRepository<FormTemplateEntity, Long> {

}
