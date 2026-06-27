package com.consultoriarhapi.service;

import com.consultoriarhapi.dto.VagaRequestDTO;
import com.consultoriarhapi.dto.VagaResponseDTO;
import com.consultoriarhapi.exception.ResourceNotFoundException;
import com.consultoriarhapi.mapper.VagaMapper;
import com.consultoriarhapi.model.Vaga;
import com.consultoriarhapi.repository.VagaRepository;
import com.consultoriarhapi.repository.EmpresaRepository;
import com.consultoriarhapi.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VagaService {

    @Autowired
    private VagaRepository repository;

    @Autowired
    private VagaMapper mapper;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public List<VagaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VagaResponseDTO buscar(Long id) {
        Vaga entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public VagaResponseDTO criar(VagaRequestDTO dto) {
        Vaga entity = mapper.toEntity(dto);
        Empresa empresa = empresaRepository.findById(dto.getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrado com id: " + dto.getEmpresaId()));
        entity.setEmpresa(empresa);
        Vaga salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public VagaResponseDTO atualizar(Long id, VagaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Vaga não encontrado com id: " + id);
        }
        Vaga entity = mapper.toEntity(dto);
        entity.setId(id);
        Empresa empresa = empresaRepository.findById(dto.getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrado com id: " + dto.getEmpresaId()));
        entity.setEmpresa(empresa);
        Vaga salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Vaga não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
