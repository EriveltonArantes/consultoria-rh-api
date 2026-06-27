package com.consultoriarhapi.service;

import com.consultoriarhapi.dto.CandidaturaRequestDTO;
import com.consultoriarhapi.dto.CandidaturaResponseDTO;
import com.consultoriarhapi.exception.ResourceNotFoundException;
import com.consultoriarhapi.mapper.CandidaturaMapper;
import com.consultoriarhapi.model.Candidatura;
import com.consultoriarhapi.repository.CandidaturaRepository;
import com.consultoriarhapi.repository.VagaRepository;
import com.consultoriarhapi.model.Vaga;
import com.consultoriarhapi.repository.CandidatoRepository;
import com.consultoriarhapi.model.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository repository;

    @Autowired
    private CandidaturaMapper mapper;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Transactional(readOnly = true)
    public List<CandidaturaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CandidaturaResponseDTO buscar(Long id) {
        Candidatura entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Candidatura não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CandidaturaResponseDTO criar(CandidaturaRequestDTO dto) {
        Candidatura entity = mapper.toEntity(dto);
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + dto.getVagaId()));
        entity.setVaga(vaga);
        Candidato candidato = candidatoRepository.findById(dto.getCandidatoId())
            .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado com id: " + dto.getCandidatoId()));
        entity.setCandidato(candidato);
        Candidatura salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CandidaturaResponseDTO atualizar(Long id, CandidaturaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Candidatura não encontrado com id: " + id);
        }
        Candidatura entity = mapper.toEntity(dto);
        entity.setId(id);
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + dto.getVagaId()));
        entity.setVaga(vaga);
        Candidato candidato = candidatoRepository.findById(dto.getCandidatoId())
            .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado com id: " + dto.getCandidatoId()));
        entity.setCandidato(candidato);
        Candidatura salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Candidatura não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
