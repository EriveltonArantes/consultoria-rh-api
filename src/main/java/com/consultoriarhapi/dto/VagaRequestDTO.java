package com.consultoriarhapi.dto;

import jakarta.validation.constraints.*;

public class VagaRequestDTO {

    @NotNull(message = "EmpresaId é obrigatório")
    @Positive(message = "EmpresaId deve ser um ID válido (positivo)")
    private Long empresaId;
    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotBlank(message = "nivel não pode estar em branco")
    private String nivel;
    @NotBlank(message = "area não pode estar em branco")
    private String area;
    @DecimalMin(value = "0.0", message = "salario não pode ser negativo")
    @NotNull(message = "salario não pode ser nulo")
    private java.math.BigDecimal salario;
    @NotBlank(message = "beneficios não pode estar em branco")
    private String beneficios;
    @NotBlank(message = "modalidade não pode estar em branco")
    private String modalidade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public java.math.BigDecimal getSalario() { return salario; }
    public void setSalario(java.math.BigDecimal salario) { this.salario = salario; }
    public String getBeneficios() { return beneficios; }
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }
    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
