package com.consultoriarhapi.repository;

import com.consultoriarhapi.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
