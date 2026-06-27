package com.consultoriarhapi.controller;

import com.consultoriarhapi.dto.CandidaturaRequestDTO;
import com.consultoriarhapi.dto.CandidaturaResponseDTO;
import com.consultoriarhapi.service.CandidaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Candidatura", description = "Gerenciamento de candidaturas")
@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService service;

    @Operation(summary = "Listar todos os Candidatura")
    @GetMapping
    public List<CandidaturaResponseDTO> listar(@RequestParam(required = false) String fase, @RequestParam(required = false) Long vagaId, @RequestParam(required = false) Long candidatoId) {
        List<CandidaturaResponseDTO> resultado = service.listar();
        if (fase != null && !fase.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getFase() != null &&
                item.getFase().toLowerCase().contains(fase.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (vagaId != null) {
            resultado = resultado.stream().filter(item -> vagaId.equals(item.getVagaId())).collect(java.util.stream.Collectors.toList());
        }
        if (candidatoId != null) {
            resultado = resultado.stream().filter(item -> candidatoId.equals(item.getCandidatoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Candidatura por ID")
    @GetMapping("/{id}")
    public CandidaturaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Candidatura")
    @PostMapping
    public ResponseEntity<CandidaturaResponseDTO> criar(@Valid @RequestBody CandidaturaRequestDTO candidatura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(candidatura));
    }

    @Operation(summary = "Atualizar Candidatura")
    @PutMapping("/{id}")
    public CandidaturaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CandidaturaRequestDTO candidatura) {
        return service.atualizar(id, candidatura);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Candidatura")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
