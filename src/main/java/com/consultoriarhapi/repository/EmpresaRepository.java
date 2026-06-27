package com.consultoriarhapi.repository;

import com.consultoriarhapi.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
