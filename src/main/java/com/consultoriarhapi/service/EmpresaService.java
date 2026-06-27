package com.consultoriarhapi.service;

import com.consultoriarhapi.dto.EmpresaRequestDTO;
import com.consultoriarhapi.dto.EmpresaResponseDTO;
import com.consultoriarhapi.exception.ResourceNotFoundException;
import com.consultoriarhapi.mapper.EmpresaMapper;
import com.consultoriarhapi.model.Empresa;
import com.consultoriarhapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EmpresaMapper mapper;

    @Transactional(readOnly = true)
    public List<EmpresaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmpresaResponseDTO buscar(Long id) {
        Empresa entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EmpresaResponseDTO criar(EmpresaRequestDTO dto) {
        Empresa entity = mapper.toEntity(dto);
        Empresa salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EmpresaResponseDTO atualizar(Long id, EmpresaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Empresa não encontrado com id: " + id);
        }
        Empresa entity = mapper.toEntity(dto);
        entity.setId(id);
        Empresa salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Empresa não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
