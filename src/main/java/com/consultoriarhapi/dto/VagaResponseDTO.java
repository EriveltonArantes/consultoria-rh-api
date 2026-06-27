package com.consultoriarhapi.dto;

public class VagaResponseDTO {

    private Long id;
    private Long empresaId;
    private String titulo;
    private String nivel;
    private String area;
    private java.math.BigDecimal salario;
    private String beneficios;
    private String modalidade;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
