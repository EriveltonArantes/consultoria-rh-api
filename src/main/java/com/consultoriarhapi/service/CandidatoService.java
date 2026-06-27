package com.consultoriarhapi.service;

import com.consultoriarhapi.dto.CandidatoRequestDTO;
import com.consultoriarhapi.dto.CandidatoResponseDTO;
import com.consultoriarhapi.exception.ResourceNotFoundException;
import com.consultoriarhapi.mapper.CandidatoMapper;
import com.consultoriarhapi.model.Candidato;
import com.consultoriarhapi.repository.CandidatoRepository;
import com.consultoriarhapi.repository.EmpresaRepository;
import com.consultoriarhapi.model.Empresa;
import com.consultoriarhapi.repository.VagaRepository;
import com.consultoriarhapi.model.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    @Autowired
    private CandidatoMapper mapper;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Transactional(readOnly = true)
    public List<CandidatoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CandidatoResponseDTO buscar(Long id) {
        Candidato entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CandidatoResponseDTO criar(CandidatoRequestDTO dto) {
        Candidato entity = mapper.toEntity(dto);
        Empresa empresa = empresaRepository.findById(dto.getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrado com id: " + dto.getEmpresaId()));
        entity.setEmpresa(empresa);
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + dto.getVagaId()));
        entity.setVaga(vaga);
        Candidato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CandidatoResponseDTO atualizar(Long id, CandidatoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Candidato não encontrado com id: " + id);
        }
        Candidato entity = mapper.toEntity(dto);
        entity.setId(id);
        Empresa empresa = empresaRepository.findById(dto.getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrado com id: " + dto.getEmpresaId()));
        entity.setEmpresa(empresa);
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + dto.getVagaId()));
        entity.setVaga(vaga);
        Candidato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Candidato não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
