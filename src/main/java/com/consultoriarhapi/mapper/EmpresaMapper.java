package com.consultoriarhapi.mapper;

import com.consultoriarhapi.dto.EmpresaRequestDTO;
import com.consultoriarhapi.dto.EmpresaResponseDTO;
import com.consultoriarhapi.model.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    Empresa toEntity(EmpresaRequestDTO dto);

    EmpresaResponseDTO toResponseDTO(Empresa entity);
}
