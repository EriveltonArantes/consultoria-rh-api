package com.consultoriarhapi.controller;

import com.consultoriarhapi.model.Empresa;
import com.consultoriarhapi.model.Vaga;
import com.consultoriarhapi.model.Candidato;
import com.consultoriarhapi.model.Candidatura;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.consultoriarhapi.repository.EmpresaRepository empresaRepository;

    @Autowired
    private com.consultoriarhapi.repository.VagaRepository vagaRepository;

    @Autowired
    private com.consultoriarhapi.repository.CandidatoRepository candidatoRepository;

    @Autowired
    private com.consultoriarhapi.repository.CandidaturaRepository candidaturaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalEmpresa", empresaRepository.count());
        resumo.put("totalVaga", vagaRepository.count());
        resumo.put("somaSalarioVaga", vagaRepository.findAll().stream().map(e -> e.getSalario()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoVaga", vagaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCandidato", candidatoRepository.count());
        resumo.put("totalCandidatura", candidaturaRepository.count());
        resumo.put("somaPontuacaoCandidatura", candidaturaRepository.findAll().stream().filter(e -> e.getPontuacao() != null).mapToDouble(e -> e.getPontuacao()).sum());
        resumo.put("graficoCandidatura", candidaturaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
