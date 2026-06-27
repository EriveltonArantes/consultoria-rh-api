package com.consultoriarhapi.mapper;

import com.consultoriarhapi.dto.CandidaturaRequestDTO;
import com.consultoriarhapi.dto.CandidaturaResponseDTO;
import com.consultoriarhapi.model.Candidatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidaturaMapper {

    @Mapping(target = "vaga", ignore = true)
    @Mapping(target = "candidato", ignore = true)
    Candidatura toEntity(CandidaturaRequestDTO dto);

    @Mapping(target = "vagaId", source = "vaga.id")
    @Mapping(target = "candidatoId", source = "candidato.id")
    CandidaturaResponseDTO toResponseDTO(Candidatura entity);
}
