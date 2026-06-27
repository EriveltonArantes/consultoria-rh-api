package com.consultoriarhapi.controller;

import com.consultoriarhapi.dto.VagaRequestDTO;
import com.consultoriarhapi.dto.VagaResponseDTO;
import com.consultoriarhapi.service.VagaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Vaga", description = "Gerenciamento de vagas")
@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    @Autowired
    private VagaService service;

    @Operation(summary = "Listar todos os Vaga")
    @GetMapping
    public List<VagaResponseDTO> listar(@RequestParam(required = false) String titulo, @RequestParam(required = false) Long empresaId) {
        List<VagaResponseDTO> resultado = service.listar();
        if (titulo != null && !titulo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTitulo() != null &&
                item.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (empresaId != null) {
            resultado = resultado.stream().filter(item -> empresaId.equals(item.getEmpresaId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Vaga por ID")
    @GetMapping("/{id}")
    public VagaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Vaga")
    @PostMapping
    public ResponseEntity<VagaResponseDTO> criar(@Valid @RequestBody VagaRequestDTO vaga) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(vaga));
    }

    @Operation(summary = "Atualizar Vaga")
    @PutMapping("/{id}")
    public VagaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody VagaRequestDTO vaga) {
        return service.atualizar(id, vaga);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Vaga")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
