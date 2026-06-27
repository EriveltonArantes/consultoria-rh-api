package com.consultoriarhapi.mapper;

import com.consultoriarhapi.dto.CandidatoRequestDTO;
import com.consultoriarhapi.dto.CandidatoResponseDTO;
import com.consultoriarhapi.model.Candidato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidatoMapper {

    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "vaga", ignore = true)
    Candidato toEntity(CandidatoRequestDTO dto);

    @Mapping(target = "empresaId", source = "empresa.id")
    @Mapping(target = "vagaId", source = "vaga.id")
    CandidatoResponseDTO toResponseDTO(Candidato entity);
}
