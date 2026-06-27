package com.consultoriarhapi.controller;

import com.consultoriarhapi.dto.EmpresaRequestDTO;
import com.consultoriarhapi.dto.EmpresaResponseDTO;
import com.consultoriarhapi.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Empresa", description = "Gerenciamento de empresas")
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @Operation(summary = "Listar todos os Empresa")
    @GetMapping
    public List<EmpresaResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<EmpresaResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Empresa por ID")
    @GetMapping("/{id}")
    public EmpresaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Empresa")
    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> criar(@Valid @RequestBody EmpresaRequestDTO empresa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(empresa));
    }

    @Operation(summary = "Atualizar Empresa")
    @PutMapping("/{id}")
    public EmpresaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EmpresaRequestDTO empresa) {
        return service.atualizar(id, empresa);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Empresa")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
