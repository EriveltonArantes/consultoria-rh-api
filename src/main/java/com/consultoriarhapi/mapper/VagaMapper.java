package com.consultoriarhapi.mapper;

import com.consultoriarhapi.dto.VagaRequestDTO;
import com.consultoriarhapi.dto.VagaResponseDTO;
import com.consultoriarhapi.model.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VagaMapper {

    @Mapping(target = "empresa", ignore = true)
    Vaga toEntity(VagaRequestDTO dto);

    @Mapping(target = "empresaId", source = "empresa.id")
    VagaResponseDTO toResponseDTO(Vaga entity);
}
